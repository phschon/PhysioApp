package physio.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exercise {

	@NotNull
	private String patient;

	@NotNull
	private String excerisePoolId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;
}
