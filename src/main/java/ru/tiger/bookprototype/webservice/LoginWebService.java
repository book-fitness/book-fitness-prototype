package ru.tiger.bookprototype.webservice;

import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");

    @Autowired
    private LoginService loginService;

    @Autowired
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

            log.info("User is logged in, id: " + user.getId());
            return Response.ok(new LoginResponse(token, null)).build();
        } catch (Exception e) {
            log.error("Try to log in failed, id: " + request.getLogin(), e);
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
