package physio.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Program {

	@Id
	@NotNull
	private String id;

	@NotNull
	private String patientId;

	@NotNull
	private String therapistId;

	@NotNull
	private String name;

	//@NotNull
	private String moduleId;
}
