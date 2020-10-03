package ru.tiger.bookprototype.webservice;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
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

    @Context
    //@Resource
    //@Inject
    private HttpServletRequest httpRequest;
    
    @Inject
    private LoginService loginService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tryLogIn(LoginRequest request) {
        try {
            HttpSession httpSession = httpRequest.getSession(false);
            SessionContext sessionContext = new SessionContext(httpSession);
            User user = loginService.tryToLogin(request.getLogin(), request.getPassword());
            sessionContext.setUser(user);
            return Response.ok(new LoginResponse(user.getUsername())).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
