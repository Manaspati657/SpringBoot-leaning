package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	private IEmployeeDAO empDao;
	
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	public List<Employee> fetchEmpDetailsByDesgs(String desg1,String desg2,String desg3) throws Exception{
		List<Employee> listEmp=null;
		try {
			listEmp=empDao.getEmpsByDesgs(desg1, desg2, desg3);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listEmp;
	}

	@Override
	public Employee fetchEmpDetailsById(String id) throws Exception{
		Employee emp=new Employee();
		try {
			emp=empDao.getEmpsById(id);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmps() throws Exception{
		List<Employee> listEmp=null;
		try {
			listEmp=empDao.getAllEmps();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listEmp;
	}

}
