package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/billing/api")
public class BillingInfoController {

	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instanse.instance-id}")
	private String instanseId;
	
	@GetMapping("/info")
	public ResponseEntity<String> fetchingBillingAddress(){
		return new ResponseEntity<String>("Final bill amount = billAmount-discount (rs.20000) ::"
				+ " using instance :: -> "+instanseId+" @Port ::"+port,HttpStatus.OK);
	}

}
