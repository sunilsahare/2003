package com.course.config;

import com.course.constants.Role;
import com.course.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.
                                requestMatchers(HttpMethod.DELETE,"/api/course/{courseId}").hasAuthority(Role.PRINCIPLE.name())
                                .requestMatchers(HttpMethod.POST,"/api/course").hasAnyAuthority(Role.PRINCIPLE.name(), Role.TEACHER.name())
                                .requestMatchers(HttpMethod.DELETE, "/api/users/{userId}").hasAuthority(Role.TEACHER.name())
                                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .anyRequest().authenticated())
                        .authenticationProvider(authenticationProvider());

        http.formLogin(form -> form.permitAll());
        http.logout((logout) ->
                        logout
//				.logoutUrl("/home/logout") // Specify the logout URL
//				.logoutSuccessUrl("/login?logout") // Redirect URL after successful logout
//				.invalidateHttpSession(true) // Invalidate the HttpSession
//				.deleteCookies("JSESSIONID") // Delete specified cookies
                                .permitAll() // Allow access to the logout URL without authentication

        );

        return http.build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
