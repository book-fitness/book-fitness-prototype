package webSecurity;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
public class UserSecurityContext implements SecurityContext {

    private UserPrincipal userPrincipal;

    public UserSecurityContext(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    @Override
    public Principal getUserPrincipal() {
        return userPrincipal;
    }

    @Override
    public boolean isUserInRole(String role) {
        //return userPrincipal.hasRole(role);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSecure() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getAuthenticationScheme() {
        return BASIC_AUTH;
    }

    public User getUser() {
        return userPrincipal.getUser();
    }
}
