package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {

	public String registerEmployee(Employee emp);
	public List<Employee> fetchAllEmployeeDetails();
}
