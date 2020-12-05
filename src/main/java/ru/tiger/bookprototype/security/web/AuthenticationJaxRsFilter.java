package ru.tiger.bookprototype.security.web;

import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import ru.tiger.bookprototype.entity.Token;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.TokenService;
import ru.tiger.bookprototype.service.UserService;

/**
 *
 * @author tiger
 */
@Secured
@Provider
//@Priority(Priorities.AUTHENTICATION)
public class AuthenticationJaxRsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @EJB
    private TokenService tokenService;

    @EJB
    private UserService userService;

    private static final String AUTHENTICATION_SCHEME = "Basic";

    //@Inject private UserService;
    @Override
    public void filter(ContainerRequestContext requestContext) {
        System.out.println("AuthenticationJaxRsFilter: " + requestContext.getMethod());

        if ("OPTIONS".equals(requestContext.getMethod())) {
            return;
        }

        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        System.out.println("Authorization: " + authorizationHeader);

        if (!isTokenBasedAuthentication(authorizationHeader)) {
            abortWithUnauthorized(requestContext);
            return;
        }

        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

        System.out.println("Token is received " + token);

        try {
            User user = validateToken(token);
            requestContext.setSecurityContext(new UserSecurityContext(user, AUTHENTICATION_SCHEME));
        } catch (Exception e) {
            abortWithUnauthorized(requestContext);
        }
    }

    private boolean isTokenBasedAuthentication(String authenticationHeader) {
        return authenticationHeader != null
                && authenticationHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE, "realm=\"" + AUTHENTICATION_SCHEME + "\"")
                        .build());
    }

    private User validateToken(String token) throws Exception {
        Token tokenValue = tokenService.findByTokenValue(token);

        if (tokenValue != null || tokenValue.isExpired()) {
            User user = userService.findByUserId(tokenValue.getUserId());
            return user;
        }
        return null;
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    }
}
