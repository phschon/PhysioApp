package physio.database.repository;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.TrainingModule;

public interface ModuleRepository extends CrudRepository<TrainingModule, String> {
}
