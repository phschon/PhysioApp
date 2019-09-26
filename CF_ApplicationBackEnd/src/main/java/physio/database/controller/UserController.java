package physio.database.controller;

import java.util.Arrays;
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

import physio.database.entities.User;
import physio.database.repository.UserRepository;
import physio.error.PhysioExceptionHandler;
import physio.error.PhysioError;

@RestController
public class UserController extends PhysioExceptionHandler {

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
		return getUsers("Patient");
	}

	@GetMapping("/users/therapists")
	public ResponseEntity<List<User>> getTherapists() {
		return getUsers("Therapist");
	}

	@GetMapping("/users/admins")
	public ResponseEntity<List<User>> getAdmins() {
		return getUsers("Admin");
	}

	@GetMapping("/users/debug")
	public ResponseEntity<String> getDebug(@AuthenticationPrincipal Token token) throws PhysioError {
		if (token == null) {
			throw new PhysioError("No token found.", PhysioError.http_code_bad_request);
		}
		String ret;
		ret = token.getAppToken();
		ret = ret + "\n" + tokenString(token);
		return new ResponseEntity<>(ret, HttpStatus.OK);

	}

	@GetMapping("/users/ownuser")
	public ResponseEntity<User> getOwnUser(@AuthenticationPrincipal Token token) throws PhysioError {
		if (token == null) {
			logger.error("TOKEN NULL");
			throw new PhysioError("No token found.", PhysioError.http_code_bad_request);
		}
		logger.info("TOKEN VALUE: " + token.getAppToken());
		logger.info("TOKEN VALUE: " + tokenString(token));
		// TODO: WTF? This looks stange
		Optional<User> first = StreamSupport.stream(userRepository.findAll().spliterator(), false).filter(u -> u.getEmail().equals(token.getLogonName())).findFirst();
		return first.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	private ResponseEntity<List<User>> getUsers(String role) {
		// TODO: this is NOT efficient! Use SQL filtering!
		return new ResponseEntity<>(getUsers().getBody().stream().filter(u -> u.getRole().equals(role)).collect(Collectors.toList()), HttpStatus.OK);
	}

	private String tokenString(Token token) {
		return String.format("Authorities: %s, expires: %s, userName: %s, logonName: %s, clientid: %s, givenName: %s, familyName: %s, email: %s, origin: %s, grantType: %s, subaccountId: %s, subdomain; %s, scopes: %s",
				token.getAuthorities(), token.getExpirationDate() == null ? null: token.getExpirationDate().toString(), token.getUsername(), token.getLogonName(), token.getClientId(), token.getGivenName(), token.getFamilyName(), token.getEmail(), token.getOrigin(), token.getGrantType(), token.getSubaccountId(), token.getSubdomain(), Arrays.toString(token.getScopes().toArray()) );
	}

}
