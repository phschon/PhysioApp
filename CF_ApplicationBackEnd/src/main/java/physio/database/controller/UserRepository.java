package physio.database.controller;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.User;

public interface UserRepository extends CrudRepository<User, String> {
}
