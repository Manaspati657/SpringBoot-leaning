package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class DateTimeRunnerTest implements CommandLineRunner{

	@Autowired IEmployeeMgmtService service;
	
	@Override
	public void run(String ...args) {
		Employee emp=new Employee();
		emp.setEname("manas pati");
		emp.setEage(23.0f);
		emp.setDob(LocalDate.of(1999, 12, 11));
		emp.setTob(LocalTime.of(11, 2,12));
		emp.setDoj(LocalDateTime.of(2022,12,14,11,00));
		//set new value before run
//		System.out.println("employee register---:::"+service.registerEmployee(emp));
		System.out.println("=-===========================");
		service.fetchAllEmployeeDetails().forEach(System.out::println);
	}
	
}


