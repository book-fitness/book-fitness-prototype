package ru.tiger.bookprototype.webservice;

import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.Token;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.security.web.DevServe;
import ru.tiger.bookprototype.service.LoginService;
import ru.tiger.bookprototype.service.TokenService;

/**
 *
 * @author Igor
 */
@DevServe
@Path("/login")
public class LoginWebService {
    @Inject
    private SessionContext sessionContext;
    @Inject
    private LoginService loginService;
    
    @EJB
    private TokenService tokenService;
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response tryLogIn(LoginRequest request) {
        try {
            User user = loginService.tryToLogin(request.getLogin(), request.getPassword());            
            Token token = tokenService.findByUserId(user.getId());
            
            if (token == null) {
                token = new Token();
                token.setToken(tokenService.generateToken());
                token.setExpirationDate(new Date());
                token.setUserId(user.getId());
            }
            
            token.resetExpirationDate();
            tokenService.saveOrUpdate(token);
            
            sessionContext.setUser(user);
            return Response.ok(new LoginResponse(token, null)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    
    @OPTIONS
    //@Path("/*")
    public Response overviewPreflight() {
        return Response
                .ok()
                //.header("Access-Control-Allow-Origin", "/*")
                //.header("Vary", "Origin")
                //.header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }
}
