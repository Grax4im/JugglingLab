import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/trick")
@Transactional
public class TrickResource {

    @POST
    @Path("/add/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Trick setName() {
        Trick trick = new Trick();
        trick.setName(name);
        trick.setDifficult(difficult);
        trick.persistAndFlush();
        return trick;
    }
}
