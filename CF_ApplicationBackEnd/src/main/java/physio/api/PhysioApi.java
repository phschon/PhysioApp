package physio.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.cloud.security.xsuaa.token.Token;

public interface PhysioApi {

	@RequestMapping(value = { "/test/{param}" }, method = RequestMethod.GET)
	ResponseEntity<String> testEndpoint(@AuthenticationPrincipal Token token, @PathVariable String param);
}
