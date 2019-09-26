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
import physio.database.entities.ExercisePool;
import physio.database.entities.TrainingModule;
import physio.database.entities.Program;
import physio.database.repository.ExerciseRepository;
import physio.database.repository.ExercisePoolRepository;
import physio.database.repository.ModuleRepository;
import physio.database.repository.ProgramRepository;

@RestController
public class ProgramController {

	private static final Log logger = LogFactory.getLog(ProgramController.class);

	@Autowired
	ExerciseRepository exerciseRepository;

	@Autowired
	ExercisePoolRepository exercisePoolRepository;

	@Autowired
	ModuleRepository moduleRepository;

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
			Program programWithModules = first.get();
			LinkedList<TrainingModule> trainingModules = new LinkedList<>();
			moduleRepository.findAll().forEach(trainingModules::add);
			LinkedList<TrainingModule> mods = new LinkedList<>();
			for (TrainingModule mod : trainingModules) {
				if (mod.getProgramId().equals(programWithModules.getId())) {
					LinkedList<Exercise> exercises = new LinkedList<>();
					exerciseRepository.findAll().forEach(exercises::add);
					LinkedList<Exercise> exer = new LinkedList<>();
					for (Exercise ex : exercises) {
						if(ex.getModuleId().equals(mod.getId())) {

							Optional<ExercisePool> matchedExerciseFromPool = StreamSupport.stream(exercisePoolRepository.findAll().spliterator(), false)
									.filter(exPool -> exPool.getId().equals(ex.getExercisePoolId())).findFirst();

//							LinkedList<ExercisePool> exercisePools = new LinkedList<>();
//							exercisePoolRepository.findAll().forEach(exercisePools::add);
////							LinkedList<ExercisePool> exPools = new LinkedList<>();
//							int counter = 0;
//							for (ExercisePool exP : exercisePools) {
//								if (exP.getId().equals(ex.getExercisePoolId())) {
//									logger.warn(counter + " " + ex.getId());
//								}
//								counter++;
//							}

							ex.setExercisePool(matchedExerciseFromPool.get());
							exer.add(ex);
						}
					}
					mod.setExercise(exer);
					mods.add(mod);
				}
			}
			programWithModules.setModule(mods);
			return new ResponseEntity<>(first.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
