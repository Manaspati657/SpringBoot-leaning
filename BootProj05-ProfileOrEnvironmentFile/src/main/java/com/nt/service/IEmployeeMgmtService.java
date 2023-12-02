package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> fetchEmpDetailsByDesgs(String desg1,String desg2,String desg3) throws Exception;
	public Employee fetchEmpDetailsById(String id) throws Exception;
	public List<Employee> getAllEmps() throws Exception;

}
