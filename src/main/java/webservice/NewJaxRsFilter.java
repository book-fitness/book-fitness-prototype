package webservice;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Igor
 */
@Provider
public class NewJaxRsFilter implements ClientRequestFilter, ClientResponseFilter, ContainerRequestFilter, ContainerResponseFilter {

    //@Inject private UserService;
    @Override
    public void filter(ClientRequestContext requestContext) {

    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) {
    }

    @Override
    public void filter(ContainerRequestContext requestContext) {
        //String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        //requestContext.setSecurityContext(arg0);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    }
}
