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
import physio.database.repository.Therapist2PatientRepository;
import physio.database.repository.UserRepository;
import physio.database.entities.Therapist2Patient;
import physio.database.entities.User;

@RequestMapping("/")
@RestController
public class PhysioApiController implements PhysioApi {

	@Autowired
	Therapist2PatientRepository therapist2PatientRepository;

	private static final Log logger = LogFactory.getLog(PhysioConfig.class);

	@Override
	public ResponseEntity<List<Therapist2Patient>> getTherapist2Patient() {
		LinkedList<Therapist2Patient> list = new LinkedList<>();
		therapist2PatientRepository.findAll().forEach(list::add);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity addTherapist2Patient(Therapist2Patient therapist2Patient) {
		therapist2PatientRepository.save(therapist2Patient);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	public ResponseEntity<String> testEndpoint(@AuthenticationPrincipal Token token,  String param) {

		logger.info("Access test endpoint: " + param);
		return new ResponseEntity<String>(param + " " + token.getClientId(), HttpStatus.OK);
	}

}
