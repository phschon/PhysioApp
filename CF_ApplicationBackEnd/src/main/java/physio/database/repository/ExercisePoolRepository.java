package physio.database.repository;

import org.springframework.data.repository.CrudRepository;
import physio.database.entities.ExercisePool;

public interface ExercisePoolRepository extends CrudRepository<ExercisePool, String> {
}
