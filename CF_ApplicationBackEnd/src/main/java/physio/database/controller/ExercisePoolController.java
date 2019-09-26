package physio.database.controller;

import io.swagger.annotations.Authorization;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import physio.database.entities.ExercisePool;

import java.util.LinkedList;
import java.util.List;

import physio.database.repository.ExercisePoolRepository;

public class ExercisePoolController {

    private static final Log logger = LogFactory.getLog(ExercisePoolController.class);

    @Autowired
    ExercisePoolRepository exercisePoolRepository;

    @GetMapping("/exercises")
    public ResponseEntity<List<ExercisePool>> getExercises() {
        LinkedList<ExercisePool> list = new LinkedList<>();
        exercisePoolRepository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
