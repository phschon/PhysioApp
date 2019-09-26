package physio.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class PhysioExceptionHandler {

	private static final Log logger = LogFactory.getLog(PhysioError.class);
	private static final String ERROR_MSG = "Exception executing %s on %s (%s). Error was: %s";

	@ExceptionHandler(PhysioError.class)
	public ResponseEntity<ErrorDto> handleEntityPersistenceException(HttpServletRequest req, PhysioError e) {
		logger.info(String.format(ERROR_MSG, req.getMethod(), req.getServletPath(), e.getClass().getSimpleName(), e.getMessage()));
		switch (e.getReturnCode()) {
		case PhysioError.http_code_bad_request:
			return new ResponseEntity<>(new ErrorDto(e.getMessage(), req.getRequestURI()), HttpStatus.BAD_REQUEST); // 400
		case PhysioError.http_code_forbidden:
			return new ResponseEntity<>(new ErrorDto(e.getMessage(), req.getRequestURI()), HttpStatus.FORBIDDEN); // 403
		case PhysioError.http_code_not_found:
			return new ResponseEntity<>(new ErrorDto(e.getMessage(), req.getRequestURI()), HttpStatus.NOT_FOUND); // 404
		case PhysioError.http_code_conflict:
			return new ResponseEntity<>(new ErrorDto(e.getMessage(), req.getRequestURI()), HttpStatus.CONFLICT); // 409
		default:
			return handleException(req, e); // like unknown exception
		}
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDto> handleException(HttpServletRequest req, Exception e) {
		logger.error(String.format(ERROR_MSG, req.getMethod(), req.getServletPath(), e.getClass().getSimpleName(), e.getMessage()), e);
		String errorMsgToApiConsumer = String.format("An unexpected error has occurred. " + ERROR_MSG, req.getMethod(), req.getServletPath(), e.getClass().getSimpleName(), e.getMessage());
		return new ResponseEntity<>(new ErrorDto(errorMsgToApiConsumer, req.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
	}

}
