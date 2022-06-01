import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Path("/trick/")
@Transactional
public class TrickResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response newTrick(Trick trick) {
        if(TrickController.create(trick)) return Response.ok(trick).build();
        //descobrir status certo pra esse erro (dados incorretos)
        return Response.status(404).build();
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
    
    @GET
    @Path("/difficult/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listByDifficult(@PathParam("number") Integer number){
        List<PanacheEntityBase> tricks = Trick.findDifficult(number);
        return Response.ok(tricks).build();
    }

    @GET
    @Path("/balls/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listByBalls(@PathParam("number") Integer number){
        List<PanacheEntityBase> tricks = Trick.findBalls(number);
        return Response.ok(tricks).build();
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
