package physio.database.controller;

import org.springframework.data.repository.CrudRepository;
import physio.database.entities.Therapist;

public interface TherapistRepository extends CrudRepository<Therapist, String> {
}
