package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("empController")
public class PayrollSystemController {

	@Autowired IEmployeeMgmtService service;
	
	public List<Employee> showEmpDetailsByDesgs(String desg1,String desg2,String desg3) throws Exception{
		List<Employee> listEmp=null;
		try {
			listEmp=service.fetchEmpDetailsByDesgs(desg1, desg2, desg3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return listEmp;
	}
	
	public Employee showEmpDetailsById(String id) throws Exception{
		Employee employee= new Employee();
		try {
			employee=service.fetchEmpDetailsById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return employee;
	}
	
	public List<Employee> showAllEmpDetails() throws Exception{
		List<Employee> listEmp=null;
		try {
			listEmp=service.getAllEmps();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return listEmp;
	}
}
