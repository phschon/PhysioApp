package physio.database.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<TrainingModule> module;
}
