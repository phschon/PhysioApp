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
public class Exercise {

	@Id
	@NotNull
	private String id;

	//@Id
	@NotNull
	//@OneToMany(mappedBy="id", targetEntity=User.class)
	private String moduleId;

	@NotNull
	private String exercisePoolId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column( length = 100000 )
	private String description;
}
