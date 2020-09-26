package webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.LoginService;

/**
 *
 * @author Igor
 */
@Path("/logInWebService")
public class LogInWebService {

    //@Context
    //@Resource
    //@Inject
    private HttpServletRequest httpRequest;
    private LoginService loginService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response tryLogIn(LogInRequest request) {
        try {
            HttpSession httpSession = httpRequest.getSession(false);
            SessionContext sessionContext = new SessionContext(httpSession);
            User user = loginService.login(request.getLogin(), request.getPassword());
            sessionContext.setUser(user);
            return Response.ok(new LogInResponse(user.getId())).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
