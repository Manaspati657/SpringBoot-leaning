package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired IEmployeeRepo empRepo;
	
	
	@Override
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		int id=empRepo.save(emp).getEmpno();
		return "Employee is saved with the id value ::"+id;
	}
	
	@Override 
	public Employee getEmployeeByNo(int id) {
		Employee emp=empRepo.findById(id).get();
		return emp;
	}
	
	@Override
	public String editEmployee(Employee emp) {
		int id=empRepo.save(emp).getEmpno();
		return "Employee is updated with the id value ::"+id;
	}
	
	@Override 
	public String deleteEmployee(int id) {
		empRepo.deleteById(id);
		return "Employee is deleted with the id value ::"+id;
	}
}
