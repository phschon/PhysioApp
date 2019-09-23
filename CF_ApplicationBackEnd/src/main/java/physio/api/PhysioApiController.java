package physio.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PhysioApiController implements PhysioApi {
	public ResponseEntity<String> getIasTenants(String param) {
		return new ResponseEntity<String>(param, HttpStatus.OK);
	}
}
