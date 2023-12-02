package com.nt.restController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/company/api")
public class CompanyOperationController {

	@GetMapping("/show")
	public ResponseEntity<Company> showCompanyDetails(){
		Company comp=new Company(101, "webskiters", "kolkata", 500, 200000000.00, "Custom");
		return new ResponseEntity<Company>(comp,HttpStatus.OK);
	}
	
	@GetMapping("/showEmployee")
	public ResponseEntity<Employee> showEmployeeDetails(){
		Company comp=new Company(101, "webskiters", "kolkata", 500, 200000000.00, "Custom");
		Employee emp=new Employee(1001, "manas ku pati", 
				new String[] {"red","blue"}, 
				List.of("mk","mkp","mana"),
				Set.of(7873630540L,985623145L), 
				Map.of("adhar",895623124578L,"VoterId",412365977L),
				true,
				LocalDateTime.of(1999, 11,12,12,11,11), comp);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
}
