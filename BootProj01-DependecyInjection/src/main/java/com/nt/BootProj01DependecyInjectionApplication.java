package com.nt;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependecyInjectionApplication {
	
	@Bean(name="cal")
	public Calendar createCalendar() {
		return Calendar.getInstance();
	}

	public static void main(String[] args) {
	  ApplicationContext ctx=SpringApplication.run(BootProj01DependecyInjectionApplication.class, args);
	
	  WishMessageGenerator wmg=ctx.getBean("wmg",WishMessageGenerator.class);
	  
	  String result=wmg.generateWishMessage("manas");
	  System.out.println("Wish message is ::"+result);
	  
	  ((ConfigurableApplicationContext)ctx).close();
	
	}

}
