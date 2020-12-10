package ru.tiger.bookprototype.security.web;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;
import org.springframework.stereotype.Service;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
@Service
public class UserSecurityContext implements SecurityContext {

    private UserPrincipal userPrincipal;
    private String authenticationScheme;

    public UserSecurityContext() {
    }

    public UserSecurityContext(UserPrincipal userPrincipal, String authenticationScheme) {
        this.userPrincipal = userPrincipal;
        this.authenticationScheme = authenticationScheme;
    }

    public UserSecurityContext(User user, String authenticationScheme) {
        this(new UserPrincipal(user), authenticationScheme);
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
        return authenticationScheme;
    }

    public User getUser() {
        return userPrincipal.getUser();
    }
}
