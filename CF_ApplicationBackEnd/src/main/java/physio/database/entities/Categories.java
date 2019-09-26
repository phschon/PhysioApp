package physio.database.entities;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class Categories {

    @Id
    @NotNull
    private String id;

    @OneToOne
    private Categories parentCategorie;

    @NotNull
    String parent_id;

    @NotNull
    String Type;

}
