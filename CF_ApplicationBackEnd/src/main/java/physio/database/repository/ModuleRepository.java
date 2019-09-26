package physio.database.repository;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.Module;
import physio.database.entities.User;

public interface ModuleRepository extends CrudRepository<Module, String> {
}
