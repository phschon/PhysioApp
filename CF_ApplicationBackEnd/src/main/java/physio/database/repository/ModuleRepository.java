package physio.database.repository;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.Module;

public interface ModuleRepository extends CrudRepository<Module, String> {
}
