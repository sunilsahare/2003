package com.employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        /**
         *
         *  internally spring refer for User and Authorities table for security
         *  if we want to use custom table other than provided table in the script
         *  do the following changes
         *
         * @Note - I'm using the same table so, commenting below code
         *
         */
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        /**
         * define a query to retrieve a user by username
         * define a query to retrieve a authorities/roles by username
         */
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select user_id, pw, active from members where user_id=?"
//        );

//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select user_id, role from roles where user_id=?"
//        );


       return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
           configure
                   .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                   .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                   .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                   .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
                   .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP basic Authentication
//        http.httpBasic(Customizer.withDefaults());
        http.formLogin(login -> login.permitAll());

        // Add logout support for default url which is '/logout'
        http.logout(logout -> logout.permitAll());

        // disable Cross Site Request Forgery (CSRF)
        // In general not request for stateless APIs that user POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /*
    // As we are using database authentication, hence below code not required
    // IN memory authentication
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.builder().username("sunil").password("{noop}sunil").roles("EMPLOYEE").build(),
                User.builder().username("admin").password("{noop}admin").roles("ADMIN").build(),
                User.builder().username("manager").password("{noop}manager").roles("MANAGER").build()
        );
    }
    */


}
