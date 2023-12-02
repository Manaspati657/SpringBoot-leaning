package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.beans2.Vehicle;
import com.nt.config.AppConfig;

public class DependecyMangementTest {

	public static void main(String[] args) {
		//Create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//this is for dependency management 
		
		//get target class object
//		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
//		
//		String result=generator.generateWishMessage("manas");
//		System.out.println("output ::::: "+result);
		
		//this is for strategy design pattern
		
		Vehicle car=ctx.getBean("vehicle",Vehicle.class);
		car.journey("kolkata", "bhubaneswar");
		//close IOC container
	    ctx.close();
	}

}
