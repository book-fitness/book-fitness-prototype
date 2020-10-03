package ru.tiger.bookprototype.webservice;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tiger
 */
@Path("/logout")
public class LogoutWebService {
    @Inject
    private SessionContext sessionContext;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        sessionContext.logout();
        return Response.ok().build();
    }
}
