package ru.tiger.bookprototype.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.security.web.Secured;
import ru.tiger.bookprototype.service.RegistrationService;

/**
 *
 * @author Igor
 */
@DevServe
@Secured
@Path("/registration")
public class RegistrationWebService {

    @Autowired
    private RegistrationService registrationService;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tryRegister(RegistrationRequest request) {
        try {
            System.out.println("Register tryRegister");
            registrationService.tryToRegister(request.getLogin(), request.getPassword(), request.getRepeatPassword());
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.serverError().build();
        }
    }

    @OPTIONS
    @Path("/register")
    public Response overviewPreflight() {
        return Response
                .ok().build();
    }
}
