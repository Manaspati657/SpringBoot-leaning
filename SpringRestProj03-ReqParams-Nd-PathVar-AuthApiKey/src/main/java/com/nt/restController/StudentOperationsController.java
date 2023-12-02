package com.nt.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentOperationsController {
	
	@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showReport(@PathVariable("sno") int no,
			            @PathVariable String sname){
		System.out.println(no+"--"+sname);
		return new ResponseEntity<String>(no+"--"+sname,HttpStatus.OK);
	}

}
