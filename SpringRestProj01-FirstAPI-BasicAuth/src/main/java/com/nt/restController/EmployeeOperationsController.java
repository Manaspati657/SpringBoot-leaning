package com.nt.restController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {

	@GetMapping("/all")
	public ResponseEntity<String> getAllEmployees(){
		System.out.println("EmployeeOperationsController.getAllEmployees()");
		return new ResponseEntity<String>("Get Mapping --fetching all Employees",HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> registerEmployee(){
		System.out.println("EmployeeOperationsController.registerEmployee()");
		return new ResponseEntity<String>("Post Mapping --save an Employee",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(){
		System.out.println("EmployeeOperationsController.updateEmployee()");
		return new ResponseEntity<String>("Put Mapping --update an Employee",HttpStatus.OK);
	}
	
	@PatchMapping("/updateEmail")
	public ResponseEntity<String> updateEmployeeEmail(){
		System.out.println("EmployeeOperationsController.updateEmployeeEmail()");
		return new ResponseEntity<String>("Patch Mapping --update an Employee email",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(){
		System.out.println("EmployeeOperationsController.deleteEmployee()");
		return new ResponseEntity<String>("Delete Mapping --Delete an Employee",HttpStatus.OK);
	}
	
}
