import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Path("/trick/")
@Transactional
public class TrickResource {

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Trick newTrick(@QueryParam("name") @NotNull String name, 
                         @QueryParam("difficult") @NotNull @Max(10) int difficult,
                         @QueryParam("balls") @Max(7) Integer balls,
                         @QueryParam("description") @NotNull String description,
                         @QueryParam("siteswap") String siteswap,
                         @QueryParam("preRequisites") String preRequisites)
                         {
        Trick trick = new Trick();
        trick.setName(name);
        trick.setDifficult(difficult);
        trick.setBalls(balls);
        trick.setDescription(description);
        trick.setSiteswap(siteswap);
        trick.setPreRequisites(preRequisites);
        trick.persist();
        return trick;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PanacheEntityBase> seeAll(){
        return Trick.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response seeOnlyOne(@PathParam("id") Long id){
        Trick entidade = Trick.findById(id);

        if(entidade == null) {
            return Response.status(404).build();
        }
        return Response.ok(entidade).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Trick trick){
        Trick idTrick = Trick.findById(id);

        if(idTrick == null) {
            return Response.status(404).build();
        }
        
        Trick newTrick = TrickController.update(id, trick);

        return Response.ok(newTrick).build();
    }


    @DELETE  
    @Path("{id}")   
    public Response delete(@PathParam("id") Long id) {  
        
        Trick trick = Trick.findById(id);

        if (trick == null) {  
            return Response.status(404).build();
        }

        trick.delete();  
        return Response.status(200).build();  
    }  
}
