package ru.tiger.bookprototype.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import ru.simplex_software.security.ulogin.UloginAuthenticationFilter;
import ru.simplex_software.security.ulogin.UloginAuthentifiactionProvider;

/**
 * Example Spring security configuration.
 * Source:
 * https://github.com/dmrzh/ulogin_spring_security/blob/master/src/test/java/ru/simplex_software/security/ulogin/ExampleSecurityConfig.java
 * 
 */
@EnableWebSecurity
public class ULoginSecurityConfig extends WebSecurityConfigurerAdapter {
    AuthenticationManager authManager;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("==== ULoginSecurityConfig: configureGlobal()");
        
        auth.authenticationProvider(new UloginAuthentifiactionProvider("localhost:8080"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("==== ULoginSecurityConfig: configure()");
        
        UloginAuthenticationFilter uloginFilter = new UloginAuthenticationFilter("/login");
        uloginFilter.setAuthenticationManager(authenticationManager());

        HttpSecurity httpSecurity = http.
                addFilterBefore(uloginFilter, AnonymousAuthenticationFilter.class);
        httpSecurity
                .authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated();
        httpSecurity.formLogin().loginPage("/login");

    }
}