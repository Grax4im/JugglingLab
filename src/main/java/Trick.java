import java.util.List;

import javax.persistence.Entity;



import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Trick  extends PanacheEntity{
    private String name;
    private int difficult;
    private int balls;
    private String description;
    private String siteswap;
    //private List<Trick> preRequisites;
    //private List<String> pictures;

    /*
    public void addPreRequisite(Trick trick) {
        this.preRequisites.add(trick);
    }
    */
}
