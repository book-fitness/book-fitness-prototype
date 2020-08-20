package ru.tiger.bookprototype.config;
/*
import javax.servlet.ServletRegistration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            int port = Config.getPort();
            System.out.println("<< EmbeddedServletContainerCustomizer " + port);
            container.setPort(port);
            container.addInitializers((sc) -> {
                
                sc.setInitParameter("contextConfigLocation", "/WEB-INF/appconfig-root.xml");
                
                sc.addListener("ru.tiger.bookprototype.servlet.listener.BPContextListener");
                sc.addListener("org.springframework.web.context.ContextLoaderListener");
                
                sc.addFilter("springSecurityFilterChain", "org.springframework.web.filter.DelegatingFilterProxy")
                        .addMappingForUrlPatterns(null, true, "/*");
                
                ServletRegistration.Dynamic srd= sc.addServlet("dispatcher", "org.springframework.web.servlet.DispatcherServlet");
                srd.setInitParameter("contextConfigLocation", "");
                srd.addMapping("/");
                
                
            });
        });
    }
}
*/