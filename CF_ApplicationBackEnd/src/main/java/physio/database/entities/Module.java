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
public class Module {

	@Id
	@NotNull
	private String id;

	@NotNull
	private String programId;

	@NotNull
	private String date;

	@NotNull
	private String description;

	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Exercise> exercise;
}
