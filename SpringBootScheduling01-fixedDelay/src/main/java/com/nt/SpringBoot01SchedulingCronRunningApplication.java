package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot01SchedulingCronRunningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01SchedulingCronRunningApplication.class, args);
	    System.out.println("App started at::"+new Date());
	}

}
