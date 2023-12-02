package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/*
 * if we use @Component annotation then we the IOC container take the class as spring bean
 * class so no need to declare that class in our configuration file
 * 
 * -> we can use @Componet("wmg") with id wmg or we can take without any id
 * then IOC Container take the full class name as id  
 * 
*/
import org.springframework.stereotype.Component;

@Component
public class WishMessageGenerator {
	
	/*
	 * if we take 2 spring bean as dependent class then ambiguity problem arises for
	 * solve this problem 3 solution are there 1: we can add primary="true" in one
	 * bean tag 2: we can take same id name with dependent key name 3: we can
	 * use @Qualifier annotation with id name which one we have required
	 * (recommended) for point 3 solution we have to add context:annotation-config
	 * tag that detects and activate multiple annotation related to
	 * BeanPostProcessor automatically during IOC container startup
	 * 
	 * note : if we use 3 method at time then qualifier is chosen by ioc containe
	 */
	
	
	
	 //this is field level auto dependency injection
		/*
		 * @Autowired
		 * 
		 * @Qualifier("dt2") public Date date;
		 */
//	-------------------------------------------------------------
		/*
		 * -> if we use autowired annotaion top of constructor then it will be
		 * constructor mode autowiring .
		 * -> we can use all the 3 solution for ambiguity problem
		 */
	//autowired annotaion with constructor
	/*
	 * public Date date;
	 * 
	 * @Autowired public WishMessageGenerator(@Qualifier("dt2")Date date) {
	 * System.out.println("WishMessageGenerator::date constructor ,with autowired constructor injection");
	 * this.date=date; }
	 */
//	---------------------------------------------------------

//	  this is normal constructor
	 
	 public WishMessageGenerator() {
	  System.out.println("WishMessageGenerator:: 0-param constructor");
	 }
	 
//-------------------------------------------------------------
		/*
		 * ->if we use Autowired annotation on the top of setter method then it performs
		 * setter injection mode autowiring
		 * -> we can use all the 3 solution for ambiguity problem
		 */
		/*
		 * public Date date;
		 * 
		 * @Autowired
		 * 
		 * @Qualifier("dt2") public void setDate(Date date) {
		 * System.out.println("Wishmessage setter method: autowired setter injection");
		 * this.date=date; }
		 */
//	 ---------------------------------------------------------------------
	 /*
		 * ->if we use Autowired annotation on the top of any method then it performs
		 * "arbitary" injection mode autowiring
		 * -> we can use all the 3 solution for ambiguity problem
		 */
	 public Date date;
	 @Autowired
	 @Qualifier("dt2") 
	 public void assign(Date date) {
		  System.out.println("Wishmessage assign method: autowired arbitary injection");
		 this.date=date; 
	 }
	 
	 
	//B.method
	@SuppressWarnings("deprecation")
	public String generateMessage(String user) {
	     System.out.println("WishMessageGenerator.generateMessage()"+date.toLocaleString());
	     
	     //get current hour of the day
		int hour=date.getHours();
	     //generate wish message
	     
	     if(hour<12) {
	    	 return "Good Morning::"+user;
	     }else if(hour<16) {
	    	 return "Good AfterNoon::"+user;
	     }else if(hour<20) {
	    	 return "Good Evening::"+user;
	     }else {
	    	 return "Good Night::"+user;
	     }
	}
}















