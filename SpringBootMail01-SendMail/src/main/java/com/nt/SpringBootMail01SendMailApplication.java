package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IPurchaseOrder;

@SpringBootApplication
public class SpringBootMail01SendMailApplication {

	public static void main(String[] args) {
		
//		get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringBootMail01SendMailApplication.class, args);
		
//		get Service class object ref
		IPurchaseOrder order=ctx.getBean("purchaseService",IPurchaseOrder.class);
		
		try {
			String msg=order.purchase(new String[] {"shirt","jeans","watch"},
					new double[] {5000.55,2000.22,6000.33},
					new String[] {"manaspati657@gmail.com","patimanas657@gmail.com",
							"lizaranisamal1@gmail.com"});
			System.out.println(msg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	
	
	}

}
