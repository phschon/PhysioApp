package physio.api;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cloud.security.xsuaa.token.Token;

import physio.PhysioConfig;
import physio.database.controller.TherapistRepository;
import physio.database.entities.Therapist;

@RequestMapping("/")
@RestController
public class PhysioApiController implements PhysioApi {

	@Autowired
	TherapistRepository therapistRepository;

	private static final Log logger = LogFactory.getLog(PhysioConfig.class);

	public ResponseEntity addT(@RequestBody Therapist therapist) {
		therapistRepository.save(therapist);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	public ResponseEntity<List<Therapist>> getT() {
		LinkedList<Therapist> list = new LinkedList<>();
		therapistRepository.findAll().forEach(list::add);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	public ResponseEntity<String> testEndpoint(@AuthenticationPrincipal Token token,  String param) {

		logger.info("Access test endpoint: " + param);
		return new ResponseEntity<String>(param + " " + token.getClientId(), HttpStatus.OK);
	}

}
