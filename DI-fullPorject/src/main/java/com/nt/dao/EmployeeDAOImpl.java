package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private DataSource ds;
	private static final String GET_EMP_INFO = "SELECT ID, NAME, PHONE, MAIL, GENDER FROM EMPLOYEE";
	
	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("Employee mysql Dao imp : 1 param constructor");
		this.ds = ds;
	}
	
	@Override
	public void getEmployee() throws Exception{
		System.out.println("Employee mysql get Employee");
		ResultSet rs=null;
		try(
				Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_EMP_INFO)
				){
			rs=ps.executeQuery();
			  while (rs.next()!=false) {
	                System.out.println( rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getString(5));
	            }
		}catch(SQLException se) {
			throw se;
		}
	}
	
}


















