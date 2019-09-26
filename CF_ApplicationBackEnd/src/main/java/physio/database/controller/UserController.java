package physio.database.controller;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import physio.PhysioConfig;
import physio.database.entities.User;
import physio.database.repository.UserRepository;

@RestController
public class UserController {

	private static final Log logger = LogFactory.getLog(PhysioConfig.class);

	@Autowired
	UserRepository userRepository;

	@PostMapping("/User")
	public ResponseEntity addT(@RequestBody User therapist) {
		userRepository.save(therapist);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@GetMapping("/User")
	public ResponseEntity<List<User>> getT() {
		LinkedList<User> list = new LinkedList<>();
		userRepository.findAll().forEach(list::add);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/User/patients")
	public ResponseEntity<List<User>> getPatients() {
		return getUsers("Patient");
	}

	@GetMapping("/User/therapists")
	public ResponseEntity<List<User>> getTherapists() {
		return getUsers("Therapist");
	}

	@GetMapping("/User/admins")
	public ResponseEntity<List<User>> getAdmins() {
		return getUsers("Admin");
	}

	private ResponseEntity<List<User>> getUsers(String role) {
		LinkedList<User> list = new LinkedList<>();
		LinkedList<User> reslist = new LinkedList<>();
		userRepository.findAll().forEach(list::add);
		for (User u: list) {
			if (u.getRole().equals(role)) {
				reslist.add(u);
			}
		}
		return new ResponseEntity<>(reslist, HttpStatus.OK);
	}

}
