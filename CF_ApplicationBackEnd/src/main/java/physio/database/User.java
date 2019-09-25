package physio.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	@NotNull
	private String id;

	@NotNull
	private String email;

	@NotNull
	private String role;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String firstName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String address;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String imageUrl;
}
