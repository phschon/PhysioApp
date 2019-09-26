package physio.database.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class ExercisePool {

    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String url;

    @NotNull
    private String categoryId;
}
