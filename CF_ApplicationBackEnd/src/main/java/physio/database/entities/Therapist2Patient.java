package physio.database.entities;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Therapist2Patient {

	@NotNull
	private String therapist;

	@NotNull
	private String patient;

}
