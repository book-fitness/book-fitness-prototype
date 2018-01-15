package ru.tiger.bookprototype;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
import ru.tiger.bookprototype.config.Config;
import ru.tiger.bookprototype.config.ServletConfig;

/**
 *
 * @author Tiger
 */

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "ru.tiger.bookprototype.**")
//@ImportResource("classpath*:WEB-INF/appconfig-root.xml")
public class Main {
    public static void main(String[] args) {
        System.out.println("main()");
        System.out.println("Start as SpringBoot Application");
        
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", Config.getPort());
        
        new SpringApplicationBuilder()
           .sources(ServletConfig.class)
           .sources(Main.class)
           //.sources(SampleController.class)                
           //.properties(props)
           .run(args);
    }
}
