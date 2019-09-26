package physio.error;

public class PhysioError extends Exception {

	private Integer returnCode = http_code_internal_error;

	public static final int http_code_no_content = 204;
	public static final int http_code_forbidden = 403;
	public static final int http_code_not_found = 404;
	public static final int http_code_internal_error = 500;
	public static final int http_code_bad_request = 400;
	public static final int http_code_conflict = 409;

	public PhysioError(String message) {
		super(message);
	}

	public PhysioError(String message, Exception ex) {
		super(message, ex);
	}

	public PhysioError(String message, Exception ex, int code) {
		super(message, ex);
		this.returnCode = code;
	}

	public PhysioError(String message, int code) {
		super(message);
		this.returnCode = code;
	}

	public int getReturnCode() {
		return returnCode;
	}
}
