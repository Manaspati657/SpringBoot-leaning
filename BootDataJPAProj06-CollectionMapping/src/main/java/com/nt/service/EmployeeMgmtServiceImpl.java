package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeInfo;
import com.nt.repo.IEmployeeInfoRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	
	@Autowired
	private IEmployeeInfoRepo repo;
	
	@Override
	public String registerEmployee(EmployeeInfo info) {
		return "Employee saved with "+repo.save(info).getEid()+" id value";
	}
	
	@Override
	public List<EmployeeInfo> getAllEmpDetails(){
		return repo.findAll();
	}
	

	
}
