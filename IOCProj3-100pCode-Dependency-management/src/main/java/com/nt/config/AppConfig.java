package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages="com.nt.beans")  //this is for dependency management
@ComponentScan(basePackages="com.nt.beans2")   //this is for strategy Design pattern
public class AppConfig {
	
	public AppConfig(){
		System.out.println("AppConfig:: 0- param constructor");
	}
	
//	@Bean(name="sysDate")
	
	//if we are not provide any name then IOC container take the method name as the bean id
	@Bean
	public LocalDateTime createLDT() {
		System.out.println("AppConfig createLDT() method");
		return LocalDateTime.now();
	}

}
