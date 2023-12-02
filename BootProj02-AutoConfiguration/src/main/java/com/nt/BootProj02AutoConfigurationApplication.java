package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dao.EmployeeDAO;

@SpringBootApplication
public class BootProj02AutoConfigurationApplication {

	public static void main(String[] args) {
	
		ApplicationContext ctx=SpringApplication.run(BootProj02AutoConfigurationApplication.class, args);
		
		EmployeeDAO dao=ctx.getBean("empDAO",EmployeeDAO.class);
		
		try {
			System.out.println("Employee count:: "+dao.getEmpsCount());
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		((ConfigurableApplicationContext)ctx).close();
	   
	
	
	
	}

}
