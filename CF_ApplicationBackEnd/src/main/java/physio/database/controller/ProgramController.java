package physio.database.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import physio.database.entities.Module;
import physio.database.entities.Program;
import physio.database.repository.ModuleRepository;
import physio.database.repository.ProgramRepository;

@RestController
public class ProgramController {

	@Autowired
	ProgramRepository programRepository;

	@GetMapping("/programs")
	public ResponseEntity<List<Program>> getModules() {
		LinkedList<Program> l = new LinkedList<>();
		programRepository.findAll().forEach(l::add);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@GetMapping("/programs/{program}")
	public ResponseEntity<Program> getModules(@PathVariable String program) {
		Optional<Program> first = StreamSupport.stream(programRepository.findAll().spliterator(), false)
				.filter(prog -> prog.getPatientId().equals(program)).findFirst();
		if (first.isPresent()) {
			return new ResponseEntity<>(first.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
