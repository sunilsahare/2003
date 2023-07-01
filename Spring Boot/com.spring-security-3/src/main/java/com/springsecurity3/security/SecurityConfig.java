package com.springsecurity3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/home/demo").permitAll()
						.requestMatchers(HttpMethod.GET, "/admin/test").permitAll()
						.requestMatchers(HttpMethod.GET, "/admin").hasAnyRole("ADMIN", "USER")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET, "/user").hasAnyRole("ADMIN", "USER")
						.requestMatchers(HttpMethod.DELETE, "/user/{userid}").hasRole("ADMIN")
						.requestMatchers("/user/**").hasRole("USER").anyRequest().authenticated());

		// http basic authentication
		http.httpBasic(Customizer.withDefaults());

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
	public InMemoryUserDetailsManager inMemoryUserDetails() {
		UserDetails user1 = org.springframework.security.core.userdetails.User.builder().username("sunil")
				.password("{noop}sunil").roles("ADMIN", "USER").build();
		UserDetails admin = org.springframework.security.core.userdetails.User.builder().username("admin")
				.password("{noop}admin").roles("ADMIN").build();
		UserDetails test = org.springframework.security.core.userdetails.User.builder().username("test")
				.password("{noop}test").roles("USER").build();
		return new InMemoryUserDetailsManager(user1, admin, test);

	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}
