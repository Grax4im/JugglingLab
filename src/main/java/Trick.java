import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Trick  extends PanacheEntity{

    @NotNull
    private String name;
    @NotNull
    private int difficult;
    @NotNull
    private int balls;
    @NotNull
    private String description;
    private String siteswap;
    private String preRequisites;
}

