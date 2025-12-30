package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
						.authenticated().requestMatchers("/notices", "/contact", "/error").permitAll());

		http.formLogin(withDefaults()); // If Form style login is required
		http.httpBasic(withDefaults());
		return http.build();

	}

	@Bean
	public UserDetailsService userDetailsService() {
		//UserDetails user = User.withUsername("user").password("{noop}12345").authorities("read").build();
		//UserDetails admin = User.withUsername("admin").password("{noop}54321").authorities("admin").build();
		
		UserDetails user = User.withUsername("user").password("{noop}12345").authorities("read").build();
		UserDetails admin = User.withUsername("admin").password("{bcrypt}$2a$13$RwjUuTCRXjZXiPDnlHm5P.vDtvsHaqN6UfRxsJEe0GG1yhgkAVt4.").authorities("admin").build();
		return new InMemoryUserDetailsManager(user, admin);

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder(); //by default
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
	}

}
