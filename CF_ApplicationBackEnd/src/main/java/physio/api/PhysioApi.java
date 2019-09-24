package physio.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface PhysioApi {

	@RequestMapping(value = { "/test/{param}" }, method = RequestMethod.GET)
	ResponseEntity<String> testEndpoint(@PathVariable String param);
}
