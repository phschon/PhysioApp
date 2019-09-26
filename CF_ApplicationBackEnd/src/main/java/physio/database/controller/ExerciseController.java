package physio.database.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import physio.database.entities.Exercise;
import physio.database.repository.ExerciseRepository;

@RestController
public class ExerciseController {

	@Autowired
	ExerciseRepository exerciseRepository;

	@GetMapping("/exercises")
	public ResponseEntity<List<Exercise>> getExercises() {
		LinkedList<Exercise> l = new LinkedList<>();
		exerciseRepository.findAll().forEach(l::add);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

}
