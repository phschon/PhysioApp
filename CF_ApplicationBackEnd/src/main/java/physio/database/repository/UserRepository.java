package physio.database.repository;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.User;

public interface UserRepository extends CrudRepository<User, String> {
}
