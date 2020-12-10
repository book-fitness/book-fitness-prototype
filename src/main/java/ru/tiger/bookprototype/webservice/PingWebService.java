package ru.tiger.bookprototype.webservice;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * REST Web Service
 *
 * @author tiger
 */
@Path("ping")
public class PingWebService {

    @Context
    private UriInfo context;

    public PingWebService() {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String ping() {
        /*JsonObject pingObj = Json.createObjectBuilder()
            .add("response", "OK")
            .add("date", new Date().toString())
            .add("currentUser", sessionContext.hasLoggedIn()
                    ? sessionContext.getUser().getUsername()
                    : "")
            .build();
        return pingObj.toString();*/
        return "ping OK";
    }
}
