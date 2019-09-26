package physio.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import physio.database.entities.*;
import physio.database.repository.*;

@Component
public class DummyContent {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ExerciseRepository exerciseRepository;

	@Autowired
	ExercisePoolRepository exercisePoolRepository;

	@Autowired
	ProgramRepository programRepository;

	@Autowired
	ModuleRepository moduleRepository;

	private String admin = "   {\n" + "        \"id\": \"a1\",\n" + "        \"email\": \"admin@123.de\",\n" + "        \"role\": \"Admin\",\n" + "        \"firstName\": \"test\",\n" + "        \"lastName\": \"admin\",\n" + "        \"address\": \"address\",\n" + "        \"imageUrl\": \"www.de\"\n" + "    }";

	@EventListener(ApplicationReadyEvent.class)
	public ResponseEntity fill() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		// generate Patient data
		fillData("sampledata_patient.json", User.class, userRepository);

		// generate Patient data
		fillData("sampledata_therapist.json", User.class, userRepository);

		// dummy admin user
		User a = mapper.readValue(admin, User.class);
		userRepository.save(a);

		// dummy exercise
		fillData("sampledata_exercise.json", Exercise.class, exerciseRepository);


		// dummy exercisePool
		fillData("sampledata_exercise_pool.json", ExercisePool.class, exercisePoolRepository);

		// dummy module
		fillData("sampledata_module.json", Module.class, moduleRepository);

		// dummy program
		fillData("sampledata_program.json", Program.class, programRepository);

		// dummy own users
		fillData("sampledata_ownUsers.json", User.class, userRepository);

		//therapist2Patient.save(th2pa);

		return new ResponseEntity(HttpStatus.OK);
	}

	private void fillData(String path, Class classT, CrudRepository repository) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		File resource = new ClassPathResource(path).getFile();
		String therapists = new String(Files.readAllBytes(resource.toPath()));
		JSONArray json = new JSONArray(therapists);
		for (Object s: json) {
			repository.save(mapper.readValue(s.toString(), classT));
		}

	}
}
