package physio.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cloud.security.xsuaa.token.Token;

import physio.PhysioConfig;

@RequestMapping("/")
@RestController
public class PhysioApiController implements PhysioApi {

	private static final Log logger = LogFactory.getLog(PhysioApiController.class);

	public ResponseEntity<String> testEndpoint(@AuthenticationPrincipal Token token,  String param) {

		logger.info("Access test endpoint: " + param);
		return new ResponseEntity<String>(param + " " + token.getClientId(), HttpStatus.OK);
	}

}
