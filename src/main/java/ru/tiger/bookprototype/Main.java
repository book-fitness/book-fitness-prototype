package ru.tiger.bookprototype;

import javax.persistence.EntityManagerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.tiger.bookprototype.entity.User;
import ru.tiger.bookprototype.service.UserService;

/*
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
/*
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "ru.tiger.bookprototype.**")
//@ImportResource("classpath*:WEB-INF/appconfig-root.xml")
public class Main {/*
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
*/

/**
 *
 * @author Igor
 */
@SpringBootApplication
@EnableTransactionManagement
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
    
    @Bean
    public CommandLineRunner runner(UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user1 = new User();
                user1.setUsername("pas");
                user1.setEmail("pas@mail.ru");
                user1.setPhone("1234567");
                user1.setPassword("qwerty1234");
                user1.setConfirmPassword("qwerty1234");
                userService.save(user1);
                
                User user2 = new User();
                user2.setUsername("isc");
                user2.setEmail("isc@mail.ru");
                user2.setPhone("1234567");
                user2.setPassword("qwerty1234");
                user2.setConfirmPassword("qwerty1234");
                userService.save(user2);
                
                User user3 = new User();
                user3.setUsername("naz");
                user3.setEmail("naz@mail.ru");
                user3.setPhone("1234567");
                user3.setPassword("qwerty1234");
                user3.setConfirmPassword("qwerty1234");
                userService.save(user1);
            }
        };
    }
}