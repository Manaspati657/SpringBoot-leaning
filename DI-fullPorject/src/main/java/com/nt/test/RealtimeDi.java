package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.dao.EmployeeDAOImpl;

public class RealtimeDi {

	public static void main(String[] args) {
		/*
		 * FileSystemXmlApplicationContext ctx= new FileSystemXmlApplicationContext(
		 * "src/main/java/com/nt/cfgs/applicationContext.xml");
		 */
		
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
//		EmployeeDAOImpl empdao=ctx.getBean("employeeDAOImpl",EmployeeDAOImpl.class);
		EmployeeDAOImpl empdao=ctx.getBean(EmployeeDAOImpl.class);
		
		System.out.println("RealtimeDi main method ");
		try {
			empdao.getEmployee();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
