package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringMsProj02ShoppingServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj02ShoppingServiceConsumerApplication.class, args);
	}

}
