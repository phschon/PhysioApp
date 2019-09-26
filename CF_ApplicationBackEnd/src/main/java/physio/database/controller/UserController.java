package physio.database.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.cloud.security.xsuaa.token.Token;

import physio.PhysioConfig;
import physio.database.entities.User;
import physio.database.repository.UserRepository;

@RestController
public class UserController {

	// TODO: this is NOT efficient! Use SQL filtering!

	private static final Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	UserRepository userRepository;

	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User therapist) {
		userRepository.save(therapist);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		LinkedList<User> list = new LinkedList<>();
		userRepository.findAll().forEach(list::add);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/users/patients")
	public ResponseEntity<List<User>> getPatients() {
		return getusers("Patient");
	}

	@GetMapping("/users/therapists")
	public ResponseEntity<List<User>> getTherapists() {
		return getusers("Therapist");
	}

	@GetMapping("/users/admins")
	public ResponseEntity<List<User>> getAdmins() {
		return getusers("Admin");
	}

	@GetMapping("/users/ownuser")
	public ResponseEntity<User> getOwnUser(@AuthenticationPrincipal Token token) {
		// TODO: WTF? This looks stange
		Optional<User> first = StreamSupport.stream(userRepository.findAll().spliterator(), false).filter(u -> u.getEmail().equals(token.getEmail())).findFirst();
		return first.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	private ResponseEntity<List<User>> getusers(String role) {
		// TODO: this is NOT efficient! Use SQL filtering!
		return new ResponseEntity<>(getusers().getBody().stream().filter(u -> u.getRole().equals(role)).collect(Collectors.toList()), HttpStatus.OK);
	}

}
