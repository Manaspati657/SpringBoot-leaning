package com.nt.restController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageApi")
public class MessageRenderController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> wishMessge(){
//		get system date and time
		LocalDateTime ldt=LocalDateTime.now();
//		generate wish message
		String msg=null;
		int hour=ldt.getHour();
		System.out.println(ldt+"--"+hour);
		if(hour<12)
			msg="Good Morning";
		else if(hour<16)
			msg="Good Afternoon::";
		else if(hour<20)
			msg="Good Evening";
		else
			msg="Good Night ,sweet dreams";
//		create and return ResponseEntity object having response content and status code
		ResponseEntity<String> entity= new ResponseEntity<String>(msg,HttpStatus.OK);
		return entity;
	}

}
