package physio.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import physio.PhysioConfig;

@RequestMapping("/")
@Controller
public class PhysioApiController implements PhysioApi {


	private static final Log logger = LogFactory.getLog(PhysioConfig.class);
	public ResponseEntity<String> testEndpoint(String param) {

		logger.info("Access test endpoint: " + param);
		return new ResponseEntity<String>(param, HttpStatus.OK);
	}
}
