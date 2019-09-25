package physio.database.entities;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainingUnit {
	@NotNull
	private String id;

	@NotNull
	private String exerciseId;

	@NotNull
	private String date;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;
}
