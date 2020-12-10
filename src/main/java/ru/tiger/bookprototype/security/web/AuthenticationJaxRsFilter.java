package ru.tiger.bookprototype.security.web;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    private static final Logger log = LogManager.getLogger("BookPrototypeLogger");
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    private static final String AUTHENTICATION_SCHEME = "Basic";

    //@Inject private UserService;
    @Override
    public void filter(ContainerRequestContext requestContext) {
        if ("OPTIONS".equals(requestContext.getMethod())) {
            return;
        }

        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (!isTokenBasedAuthentication(authorizationHeader)) {
            log.warn("Invalid authoirization header: " + authorizationHeader);
            abortWithUnauthorized(requestContext);
            return;
        }

        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
        try {
            User user = validateToken(token);
            requestContext.setSecurityContext(new UserSecurityContext(user, AUTHENTICATION_SCHEME));
        } catch (Exception e) {
            log.error("Token validation failed, token " + token, e);
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

        if (tokenValue == null) {
            log.warn("Token not found, token " + tokenValue);
            throw new RuntimeException("Token not found, token " + tokenValue);
        }
        if (tokenValue.isExpired()) {
            tokenService.remove(tokenValue);
            log.warn("Token is expired, token " + tokenValue);
            throw new RuntimeException("Token is expired, token " + tokenValue);
        } else {
            User user = userService.findByUserId(tokenValue.getUserId());
            tokenValue.resetExpirationDate();
            tokenService.saveOrUpdate(tokenValue);
            log.info("Token is accepted, token " + tokenValue + ", userId " + user.getId());
            return user;
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    }
}
