package physio.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import physio.database.controller.Therapist2PatientRepository;
import physio.database.controller.UserRepository;
import physio.database.entities.Therapist2Patient;
import physio.database.entities.User;

@Controller
public class DummyContent {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Therapist2PatientRepository therapist2Patient;

	private String admin = "   {\n" + "        \"id\": \"a1\",\n" + "        \"email\": \"admin@123.de\",\n" + "        \"role\": \"a\",\n" + "        \"firstName\": \"test\",\n" + "        \"lastName\": \"admin\",\n" + "        \"address\": \"address\",\n" + "        \"imageUrl\": \"www.de\"\n" + "    }";
	private String patient = "   {\n" + "        \"id\": \"p1\",\n" + "        \"email\": \"patient@123.de\",\n" + "        \"role\": \"p\",\n" + "        \"firstName\": \"test\",\n" + "        \"lastName\": \"patient\",\n" + "        \"address\": \"address\",\n" + "        \"imageUrl\": \"www.de\"\n" + "    }";
	private String therapist = "   {\n" + "        \"id\": \"t1\",\n" + "        \"email\": \"therapist@123.de\",\n" + "        \"role\": \"t\",\n" + "        \"firstName\": \"test\",\n" + "        \"lastName\": \"therapist\",\n" + "        \"address\": \"address\",\n" + "        \"imageUrl\": \"www.de\"\n" + "    }";

	private String t2p = "{\"therapist\": \"t1\", \"patient\": \"p1\"}";

	@PostMapping("/initial")
	public ResponseEntity fill() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		User a = mapper.readValue(admin, User.class);
		userRepository.save(a);
		User p = mapper.readValue(patient, User.class);
		userRepository.save(p);
		User t = mapper.readValue(therapist, User.class);
		userRepository.save(t);
		Therapist2Patient th2pa = mapper.readValue(t2p, Therapist2Patient.class);
		//therapist2Patient.save(th2pa);

		return new ResponseEntity(HttpStatus.OK);
	}
}
