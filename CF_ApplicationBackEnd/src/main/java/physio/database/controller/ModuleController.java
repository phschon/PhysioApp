package physio.database.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import physio.database.entities.TrainingModule;
import physio.database.repository.ModuleRepository;

@RestController
public class ModuleController {

	@Autowired
	ModuleRepository moduleRepository;

	@GetMapping("/modules")
	public ResponseEntity<List<TrainingModule>> getModules() {
		LinkedList<TrainingModule> l = new LinkedList<>();
		moduleRepository.findAll().forEach(l::add);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

}
