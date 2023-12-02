package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


import com.nt.beans.PersonalInfo;

@SpringBootApplication
public class BootProj04PropertiesFileValueNdConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(BootProj04PropertiesFileValueNdConfigurationPropertiesApplication.class, args);
	
		//get spring bean class object
		
//		Hospital hsHospital=ctx.getBean("hsptl",Hospital.class);
//		System.out.println("spring bean class obj data"+hsHospital);
		
//		Customer info=ctx.getBean("customer",Customer.class);
//		System.out.println("Customer information :::"+info);
		
//		with configruration we can fetch array and all collection framework from properties file
		PersonalInfo info=ctx.getBean("pInfo",PersonalInfo.class);
		System.out.println("Personal information :::"+info);
		
		((ConfigurableApplicationContext)ctx).close();
		
//		System.out.println("System properties ::"+System.getProperties());
	
	}

}


