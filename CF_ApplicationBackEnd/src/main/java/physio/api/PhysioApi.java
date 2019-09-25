package physio.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.cloud.security.xsuaa.token.Token;

import physio.database.entities.Therapist2Patient;
import physio.database.entities.User;

public interface PhysioApi {

	@RequestMapping(value = { "/t2p" }, method = RequestMethod.GET)
	ResponseEntity<List<Therapist2Patient>> getTherapist2Patient();

	@RequestMapping(value = { "/t2p" }, method = RequestMethod.POST)
	ResponseEntity addTherapist2Patient(@RequestBody Therapist2Patient therapist2Patient);

	@RequestMapping(value = { "/users" }, method = RequestMethod.POST)
	ResponseEntity addT(@RequestBody User therapist);

	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	ResponseEntity<List<User>> getT();

	@RequestMapping(value = { "/test/{param}" }, method = RequestMethod.GET)
	ResponseEntity<String> testEndpoint(@AuthenticationPrincipal Token token, @PathVariable String param);
}
