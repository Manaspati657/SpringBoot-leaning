package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.EmployeeInfoRepo;
import com.nt.entity.Employee;

@Service("empService")
public class EmployeeInfoRepoImpl implements IEmployeeMgmtService {

	@Autowired EmployeeInfoRepo repo;
	
	@Override
	public String registerEmployee(Employee emp) {
		return repo.save(emp).getEmpid()+"  Employee is saved";
	}
	
	@Override
	public List<Employee> fetchAllEmployeeDetails(){
		return repo.findAll();
	}
}
