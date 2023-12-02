package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestMs")
public class TestServiceController {
	
	@GetMapping("/show")
	public ResponseEntity<String> displayMsg(){
		return new ResponseEntity<String>("welcome to spring boot ms",HttpStatus.OK);
	}
	

}
