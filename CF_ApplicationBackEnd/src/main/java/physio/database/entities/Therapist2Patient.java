package physio.database.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(Therapist2Patient.T2PPK.class)
public class Therapist2Patient implements Serializable {

	@Id
	@NotNull
	//@ManyToMany(mappedBy="id", targetEntity=User.class)
	private String therapist;

	@Id
	@NotNull
	//@ManyToMany(mappedBy="id", targetEntity=User.class)
	private String patient;

	public class T2PPK implements Serializable {
		String therapist;
		String patient;

		public T2PPK() {}

		public T2PPK(String therapist, String patient) {
			this.therapist = therapist;
			this.patient = patient;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			T2PPK t2PPK = (T2PPK) o;
			return Objects.equals(therapist, t2PPK.therapist) && Objects.equals(patient, t2PPK.patient);
		}

		@Override
		public int hashCode() {
			return Objects.hash(therapist, patient);
		}
	}
}
