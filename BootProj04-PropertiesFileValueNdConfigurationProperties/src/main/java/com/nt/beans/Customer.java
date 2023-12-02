package com.nt.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component("customer")
@ConfigurationProperties("cust.info")
@Setter
public class Customer {
	
	private String name;
	private int age;
	private float salary;
	private String address;

	@Override
	public String toString() {
		return "Customer detials::"+name+" "+age+" "+salary+" "+address;
	}
}
