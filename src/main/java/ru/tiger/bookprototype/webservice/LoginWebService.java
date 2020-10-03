package ru.tiger.bookprototype.webservice;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.LoginService;

/**
 *
 * @author Igor
 */
@Path("/login")
public class LoginWebService {
    @Inject
    private SessionContext sessionContext;
    @Inject
    private LoginService loginService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response tryLogIn(LoginRequest request) {
        try {
            User user = loginService.tryToLogin(request.getLogin(), request.getPassword());
            if (user == null) throw new RuntimeException("Failure login: " + request.getLogin());
            sessionContext.setUser(user);
            return Response.ok(new LoginResponse(user)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
