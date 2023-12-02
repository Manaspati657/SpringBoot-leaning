package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Annotation to activate Eureka server related configurtion EruekaServerAutoConfiguration
public class SpringMsProj01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj01EurekaServerApplication.class, args);
	}

}
