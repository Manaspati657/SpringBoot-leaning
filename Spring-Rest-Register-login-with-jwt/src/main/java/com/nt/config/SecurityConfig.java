package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nt.filter.JwtFilter;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired JwtFilter authFilter;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
		.csrf().disable()
        .authorizeRequests()
        .antMatchers("/api/auth/**").permitAll()
        .and()
        .authorizeRequests()
        .antMatchers("/api/employee/**")
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
        ;
		  
		return http.build();
	}
	
	@Bean
	static PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	}
	

}
