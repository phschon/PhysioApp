package physio.database.repository;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, String> {
}
