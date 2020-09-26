/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class NewJaxRsFilter1 implements ClientRequestFilter, ClientResponseFilter, ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ClientRequestContext requestContext) {
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) {
    }

    @Override
    public void filter(ContainerRequestContext requestContext) {
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    }
    
}
