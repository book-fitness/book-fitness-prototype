package ru.tiger.bookprototype.webservice;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import ru.tiger.bookprototype.entity.Token;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.security.web.Secured;
import ru.tiger.bookprototype.security.web.UserPrincipal;
import ru.tiger.bookprototype.service.TokenService;

/**
 *
 * @author tiger
 */
@Secured
@DevServe
@Path("/logout")
public class LogoutWebService {

    @Inject
    private SessionContext sessionContext;
    
    @Context
    private SecurityContext securityContext;

    @EJB
    private TokenService tokenService;

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        sessionContext.logout();
        return Response.ok().build();
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/logoutToken")
    public Response logoutSevice() {
        System.out.println("Inside logout {token}");
        try {
            User user = ((UserPrincipal) securityContext.getUserPrincipal()).getUser();
            Token token = tokenService.findByUserId(user.getId());
            System.out.println("Logout user " + user.getUsername() + ", token " + token.getToken());
            tokenService.remove(token);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    
    @OPTIONS
    @Path("/logoutToken")
    public Response overviewPreflight1() {
        return Response.ok().build();
    }
}
