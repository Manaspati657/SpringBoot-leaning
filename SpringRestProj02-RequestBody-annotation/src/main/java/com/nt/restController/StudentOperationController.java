package com.nt.restController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Student;

@RestController
@RequestMapping("/student/api")	
public class StudentOperationController {

//	@ResponseBody (implicit annotation because of @RestController
	@PostMapping("/register")
	public ResponseEntity<Student> registerEmployee(@RequestBody Student stud){
//	@RequestBody  --> performs DeSerializtion / unmarshalling activities while receiving
//		content from body of the http request
//  @ResponseBody --> performs Serialization / marshaling activities while putting the 
//		content into http response from ResponseEntity object
		System.out.println("StudentOperationController.registerEmployee()");
		return new ResponseEntity<Student>(stud,HttpStatus.CREATED);
	}
}
