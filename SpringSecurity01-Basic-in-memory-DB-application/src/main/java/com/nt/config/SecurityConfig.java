package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		Build authentication Manager by taking given Authentication info provider (InMemoryDB)
		
		auth.inMemoryAuthentication().withUser("manas").password("{noop}manas123").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("ranjan").password("{noop}ranjan123").roles("CUSTOMER");
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/").permitAll() //not authentication and no authorization
		.antMatchers("/offers").authenticated() //only authentication
		.antMatchers("/balance").hasAnyRole("MANAGER","CUSTOMER") // authentication + authorization for customer and manager
		.antMatchers("/loanApprove").hasRole("MANAGER") 
		.anyRequest().authenticated() // remaining all requests url must be authenticate
		
//		specify authentication mode
		.and().httpBasic()
		
//		exception/error handling for 403 error
		
		.and().exceptionHandling().accessDeniedPage("/denied");
	
	}
}
