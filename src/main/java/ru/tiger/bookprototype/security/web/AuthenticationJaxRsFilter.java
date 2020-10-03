package ru.tiger.bookprototype.security.web;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author tiger
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationJaxRsFilter implements ContainerRequestFilter, ContainerResponseFilter {
    
    private static final String AUTHENTICATION_SCHEME = "Bearer";

    //@Inject private UserService;
    @Override
    public void filter(ContainerRequestContext requestContext) {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if (!isTokenBasedAuthentication(authorizationHeader)) {
            abortWithUnauthorized(requestContext);
            return;
        }
        
        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
        
        try {
            User user = validateToken(token);
            requestContext.setSecurityContext(new UserSecurityContext(user, AUTHENTICATION_SCHEME));
        } catch (Exception e) {
            abortWithUnauthorized(requestContext);
        }
    }
    
    private boolean isTokenBasedAuthentication(String authenticationHeader) {
        return authenticationHeader != null &&
               authenticationHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }
    
    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        throw new UnsupportedOperationException();
    }
    
    private User validateToken(String token) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    }
}
