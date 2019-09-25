package physio.database.entities;

import javax.validation.constraints.NotNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TherapyPlan {
	@NotNull
	private String id;

	@NotNull
	private String patient;

	@NotNull
	private String therapist;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<TrainingUnit> trainingUnits;


}
