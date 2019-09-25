package physio.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import physio.database.controller.Therapist2PatientRepository;
import physio.database.controller.UserRepository;
import physio.database.entities.Therapist2Patient;
import physio.database.entities.User;

@Component
public class DummyContent {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Therapist2PatientRepository therapist2Patient;

	private String admin = "   {\n" + "        \"id\": \"a1\",\n" + "        \"email\": \"admin@123.de\",\n" + "        \"role\": \"a\",\n" + "        \"firstName\": \"test\",\n" + "        \"lastName\": \"admin\",\n" + "        \"address\": \"address\",\n" + "        \"imageUrl\": \"www.de\"\n" + "    }";

	private String t2p = "{\"therapist\": \"t1\", \"patient\": \"p1\"}";

	@EventListener(ApplicationReadyEvent.class)
	public ResponseEntity fill() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		// generate Patient data
		File resource = new ClassPathResource("sampledata_patient.json").getFile();
		String patients = new String(Files.readAllBytes(resource.toPath()));
		JSONArray json = new JSONArray(patients);
		for (Object s: json) {
			userRepository.save(mapper.readValue(s.toString(), User.class));
		}

		// generate Patient data
		resource = new ClassPathResource("sampledata_therapist.json").getFile();
		String therapists = new String(Files.readAllBytes(resource.toPath()));
		json = new JSONArray(therapists);
		for (Object s: json) {
			userRepository.save(mapper.readValue(s.toString(), User.class));
		}

		// dummy admin user
		User a = mapper.readValue(admin, User.class);
		userRepository.save(a);

		Therapist2Patient th2pa = mapper.readValue(t2p, Therapist2Patient.class);
		//therapist2Patient.save(th2pa);

		return new ResponseEntity(HttpStatus.OK);
	}
}
