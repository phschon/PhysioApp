package physio.database.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@NotNull
	private String id;

	@NotNull
	String email;

	@NotNull
	String role;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String firstName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String address;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String imageUrl;
}
