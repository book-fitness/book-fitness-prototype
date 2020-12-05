package ru.tiger.bookprototype.webservice;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ru.tiger.bookprototype.security.web.AuthenticationJaxRsFilter.class);
        resources.add(ru.tiger.bookprototype.security.web.DevServeJaxRsFilter.class);
        resources.add(ru.tiger.bookprototype.webservice.ArticleLikeWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.ArticleWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.BookLikeWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.BookWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.CommentLikeWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.CommentWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.LoginWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.LogoutWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.PingWebService.class);
        resources.add(ru.tiger.bookprototype.webservice.RegistrationWebService.class);
    }  
}
