package ru.tiger.bookprototype.webservice;

import java.time.Instant;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * REST Web Service
 *
 * @author tiger
 */
@Path("ping")
public class PingWebService {

    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");
    
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
        
        Instant now = Instant.now();
        log.info("== (log) PingWebService: " + now);
        System.out.println("== (sout) PingWebService: " + now);
        
        return "ping OK, " + now;
    }
}
