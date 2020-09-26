package webservice;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.service.RegistrationService;

/**
 *
 * @author Igor
 */

@Path("/registrationWebService")
public class RegistrationWebService {
   
    @EJB
    private RegistrationService registrationService;
    
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tryRegister(RegistrationRequest request) {
       try {
           registrationService.tryToRegister(request.getLogin(), request.getPassword());
           return Response.status(Response.Status.CREATED).build();
       } catch(Exception ex) {
           ex.printStackTrace();
           return Response.serverError().build();
       }
   }
}
