import java.util.List;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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

    public static List<PanacheEntityBase> findDifficult(Integer number){
        return list("difficult", number);
    }

    public static List<PanacheEntityBase> findBalls(Integer number){
        return list("balls", number);
    }

}

