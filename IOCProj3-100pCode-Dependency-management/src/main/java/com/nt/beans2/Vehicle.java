package com.nt.beans2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

	@Autowired
	@Qualifier("diesel")
	private Engine engg;
	
	public Vehicle() {
		System.out.println("Vehicle ::0-param constructor");
	}
	
	public void journey(String startPlace,String destPlace) {
		engg.start();
		System.out.println("Vehicle:: journey started at::"+startPlace);
		System.out.println("Journey is going on.................");
		engg.stop();
		System.out.println("Vehicle :: journey stopped at ::"+destPlace);
	}
}
