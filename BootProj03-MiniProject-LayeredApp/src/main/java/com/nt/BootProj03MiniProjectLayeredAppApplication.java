package com.nt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollSystemController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjectLayeredAppApplication {

	public static void main(String[] args) {
		
		String desg1=null,desg2=null,desg3=null,id=null;
		
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj03MiniProjectLayeredAppApplication.class, args);
	
		//Get Controller class object 
		PayrollSystemController controller=ctx.getBean("empController",PayrollSystemController.class);
		
		try (//gather inputs from end user
		Scanner scanner = new Scanner(System.in)) {
			
			System.out.println("Choose your option :: \n "
					+ "i)for get by id : 1 \n "
					+ "ii)for get By designation:2 \n "
					+ "iii)for get All Employee :: 3 \n");
			int choose=scanner.nextInt();
			
			if(choose==1) {
				System.out.println("Enter employee id :: \n ");
				id=scanner.next().toLowerCase();
			}else if(choose==2 ) {
				System.out.println("Enter Desg1 :: \n");
				desg1=scanner.next().toLowerCase();
				
				System.out.println("Enter Desg2 :: \n");
				desg2=scanner.next().toLowerCase();
				
				System.out.println("Enter Desg3 :: \n");
				desg3=scanner.next().toLowerCase();
			}
			
			List<Employee> listEmps=null;
			Employee employee=new Employee();
			try {
				if(choose==1 & id != null) {
					employee=controller.showEmpDetailsById(id);
					System.out.println(employee);
				}else if(choose==2 & (desg1 !=null || desg2 !=null || desg3 != null)) {
					listEmps=controller.showEmpDetailsByDesgs(desg1, desg2, desg3);
					
					//enhanced for loop
//				for(Employee e:listEmps) { System.out.println(e); }
					 
					
					//java8 forEach syntax
//				listEmps.forEach(emp-> System.out.println(emp));
					
					//java8 forEach with method referench concept
					listEmps.forEach(System.out::println);
				}else if(choose==3) {
					listEmps=controller.showAllEmpDetails();
					listEmps.forEach(System.out::println);
				}
				
				
			}catch (SQLException se) {
				// TODO: handle exception
				se.printStackTrace();
				System.out.println("Internal DB problem::");
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Internal DB problem::");
			}
		}
		((ConfigurableApplicationContext)ctx).close();
		
	}

}











