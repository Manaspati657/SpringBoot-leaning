package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg") //spring bean having "wmg" as the bean id
public class WishMessageGenerator {
	
	//Has-A property
	@Autowired //Annotation marking the Has-A property for Dependency injection/Management
	//by default dt holds null ,after injection/wiring this null will be replaced with 
	//dependent LocalDateTime class object
	private LocalDateTime ldt;

	public WishMessageGenerator() {
		System.out.println("Wishmessage generator :: 0 param constructor");
	}
	
	public String generateWishMessage(String user) {
		System.out.println("ldt --- "+this.ldt);
		
		int hour=ldt.getHour();
		if(hour<12) return "Good Moring::"+user;
		else if(hour<16) return "Good Afternoon::"+user;
		else if(hour<20) return "Good Evening::"+user;
		else return "Good Night::"+user;
	}
	
	

}
