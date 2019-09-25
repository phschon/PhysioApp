package physio.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.cloud.security.xsuaa.token.Token;

import physio.database.entities.Therapist;

public interface PhysioApi {

	@RequestMapping(value = { "/therapists" }, method = RequestMethod.POST)
	ResponseEntity addT(@RequestBody Therapist therapist);

	@RequestMapping(value = { "/therapists" }, method = RequestMethod.GET)
	ResponseEntity<List<Therapist>> getT();

	@RequestMapping(value = { "/test/{param}" }, method = RequestMethod.GET)
	ResponseEntity<String> testEndpoint(@AuthenticationPrincipal Token token, @PathVariable String param);
}
