package physio.database.controller;

import org.springframework.data.repository.CrudRepository;

import physio.database.entities.Therapist2Patient;
import physio.database.entities.User;

public interface Therapist2PatientRepository extends CrudRepository<Therapist2Patient, String> {
}
