package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class ProjectSecurityConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll()); // No login screen will come up
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
				.requestMatchers("/notices","/contact","/error").permitAll());
		
		http.formLogin(withDefaults()); // If Form style login is required
		//http.formLogin(flc -> flc.disable());
		http.httpBasic(withDefaults());
		//http.httpBasic(hbc -> hbc.disable());
		return http.build();
		
	}

}
