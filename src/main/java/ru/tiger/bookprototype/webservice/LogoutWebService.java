package ru.tiger.bookprototype.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");
    
    @Context
    private SecurityContext securityContext;

    @Autowired
    private TokenService tokenService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/logoutToken")
    public Response logoutSevice() {
        User user = ((UserPrincipal) securityContext.getUserPrincipal()).getUser();
        try {
            Token token = tokenService.findByUserId(user.getId());
            tokenService.remove(token);
            log.info("User is logged out, id " + user.getId());
            return Response.ok().build();
        } catch (Exception e) {
            log.error("Try to log out failed, id " + (user == null ? "null" : user.getId()));
            return Response.serverError().build();
        }
    }
    
    @OPTIONS
    @Path("/logoutToken")
    public Response overviewPreflight1() {
        return Response.ok().build();
    }
}
