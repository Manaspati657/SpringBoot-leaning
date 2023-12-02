package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDAO")
public class EmployeeDAO {

	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMPLOYEE";
	
	@Autowired
	private DataSource ds;
	
	public int getEmpsCount() throws Exception {
		
		Connection con=ds.getConnection();
		
		PreparedStatement ps=con.prepareStatement(GET_EMPS_COUNT);
		
		ResultSet rs=ps.executeQuery();
		
		rs.next();
		
		int count=rs.getInt(1);
		
		rs.close();
		ps.close();
		con.close();
		
		return count;
		
	}
}
