package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
	}


	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/rest/**").authenticated().anyRequest().permitAll().and()
		.authorizeRequests().antMatchers("/secure/**").authenticated().anyRequest().hasAnyRole("Admin").and()
		.formLogin().permitAll();

		
		

	}

	
	
	
	
	@Bean
	BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}

}
