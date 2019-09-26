package physio.database.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Module {

	@Id
	@NotNull
	private String id;

	@NotNull
	private String exerciseId;

	@NotNull
	private String date;

	@NotNull
	private String template;
}
