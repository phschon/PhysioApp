package physio.database.repository;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.Program;

public interface ProgramRepository extends CrudRepository<Program, String> {
}
