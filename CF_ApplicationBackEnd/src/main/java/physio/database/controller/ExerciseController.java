package physio.database.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import physio.database.entities.Exercise;
import physio.database.entities.Program;
import physio.database.repository.ExerciseRepository;

@RestController
public class ExerciseController {

	private static final Log logger = LogFactory.getLog(ExerciseController.class);


	@Autowired
	ExerciseRepository exerciseRepository;

	@GetMapping("/exercises")
	public ResponseEntity<List<Exercise>> getExercises() {
		LinkedList<Exercise> exercise = new LinkedList<>();
		exerciseRepository.findAll().forEach(exercise::add);
		return new ResponseEntity<>(exercise, HttpStatus.OK);
	}

}
