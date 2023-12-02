package com.nt.restController;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationController {

	@Autowired private IBillingServiceConsumerClient client;
	
	@GetMapping("/cart")
	public ResponseEntity<String> doShopping(){
		
		System.out.println("proxy class name::"+client.getClass()+"---------"+Arrays.toString(client.getClass().getInterfaces()));
		
//		use clint comp
		String resultMsg=client.fetchingBillingInfo().getBody();
		
		return new ResponseEntity<String>("Shopping the items (shirt,trouser) ::::"+resultMsg,HttpStatus.OK);
		
	}
}
