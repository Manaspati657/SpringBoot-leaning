package com.nt.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	
	@GetMapping("all")
	public String getEmployee() {
		return "all employee";
	}
	
	@GetMapping("{id}")
	public String getEmployeeById(@PathVariable int id) {
		return "employee by id";
	}
}
