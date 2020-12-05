package ru.tiger.bookprototype.security.web;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@DevServe
@Provider
public class DevServeJaxRsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println("DevServeJaxRsFilter: " + requestContext.getMethod());
        UriInfo uriInfo = requestContext.getUriInfo();
        String host = uriInfo.getRequestUri().getHost();
        System.out.println("UriInfo: " + uriInfo.toString());
        System.out.println("Host: " + uriInfo.getRequestUri().getHost());

        if (host.equals("localhost")) {
            System.out.println("Added headers: Access-Control-Allow-Origin, Access-Control-Allow-Headers");
            responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
            responseContext.getHeaders().add("Access-Control-Allow-Headers", "*");
        }
    }
}
