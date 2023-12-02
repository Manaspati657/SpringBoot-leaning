package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_BY_DESGS="SELECT EMPID,NAME,PHONE,MAIL,DESIGNATION,SALARY FROM EMPLOYEE"
			+ " WHERE DESIGNATION IN (?,?,?) AND ISACTIVE =1 ORDER BY SALARY";
	private static final String GET_EMPS_BY_Id="SELECT EMPID,NAME,PHONE,MAIL,DESIGNATION,SALARY FROM EMPLOYEE"
			+ " WHERE EMPID = (?) AND ISACTIVE = 1";
	private static final String GET_ALL_EMPS="SELECT EMPID,NAME,PHONE,MAIL,DESIGNATION,SALARY FROM EMPLOYEE"
			+ " WHERE ISACTIVE = 1";
	
	@Autowired DataSource ds;
	
	@Override
	public List<Employee> getEmpsByDesgs(String desg1,String desg2,String desg3) throws Exception{
		List<Employee> listEmps=null;
		
		try(
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS);
			){
			  ps.setString(1, desg1);
			  ps.setString(2, desg2);
			  ps.setString(3, desg3);
			 
			  try(
				  ResultSet rs=ps.executeQuery();
					  ){
				  listEmps=new ArrayList<Employee>();
				  while(rs.next()) {
					  Employee emp=new Employee();
					  emp.setEmpno(rs.getString(1));
					  emp.setEname(rs.getString(2));
					  emp.setPhone(rs.getLong(3));
					  emp.setMail(rs.getString(4));
					  emp.setDesignation(rs.getString(5));
					  emp.setSalary(rs.getLong(6));
					  listEmps.add(emp);
				  }
				  
			  }
			
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listEmps;
	}

	@Override
	public Employee getEmpsById(String id)throws Exception{
		
		Employee emp=new Employee();
		try(
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_Id);
			){
			  ps.setString(1, id);
			 
			  try(
				  ResultSet rs=ps.executeQuery();
					  ){
				  while(rs.next()) {
					  emp.setEmpno(rs.getString(1));
					  emp.setEname(rs.getString(2));
					  emp.setPhone(rs.getLong(3));
					  emp.setMail(rs.getString(4));
					  emp.setDesignation(rs.getString(5));
					  emp.setSalary(rs.getLong(6));
				  }
				  
			  }
			
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return emp;
	}


	@Override
	public List<Employee> getAllEmps() throws Exception{
    List<Employee> listEmps=null;
		try(
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_ALL_EMPS);
			){
			  try(
				  ResultSet rs=ps.executeQuery();
					  ){
				  listEmps=new ArrayList<Employee>();
				  while(rs.next()) {
					  Employee emp=new Employee();
					  emp.setEmpno(rs.getString(1));
					  emp.setEname(rs.getString(2));
					  emp.setPhone(rs.getLong(3));
					  emp.setMail(rs.getString(4));
					  emp.setDesignation(rs.getString(5));
					  emp.setSalary(rs.getLong(6));
					  listEmps.add(emp);
				  }
				  
			  }
			
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listEmps;
	}



}








