package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		WishMessageGenerator wmg=ctx.getBean(WishMessageGenerator.class);
		
//		WishMessageGenerator wmg=ctx.getBean("wmg",WishMessageGenerator.class);

//		WishMessageGenerator wmg2=ctx.getBean("wmg",WishMessageGenerator.class);
		
		System.out.println("main method setter injection test");
		
		String msg=wmg.generateMessage("manas");
	   
		System.out.println("wish message:: "+msg);
		
		/*
		 * System.out.println("wmg hascode :: "+wmg.hashCode());
		 * System.out.println("wmg2 hascode :: "+wmg2.hashCode());
		 */
		
		ctx.close();
	}

}
