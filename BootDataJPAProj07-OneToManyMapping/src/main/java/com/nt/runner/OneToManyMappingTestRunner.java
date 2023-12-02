package com.nt.runner;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IOneToManyMappingMgmtService;

@Component
public class OneToManyMappingTestRunner implements CommandLineRunner {

	@Autowired IOneToManyMappingMgmtService service;
	
	@Override
	public void run(String ...args)throws Exception {
		
//		prepare child objects
		PhoneNumber ph=new PhoneNumber();
		ph.setPhoneNumber(8745122356L);
		ph.setNumberType("personal");
		ph.setProvider("jio");
		
		PhoneNumber ph1=new PhoneNumber();
		ph1.setPhoneNumber(7745212356L);
		ph1.setNumberType("office");
		ph1.setProvider("vodafone");
		
//		prepare parent object
		Person per=new Person();
		per.setPname("liza");
		per.setPaddress("jajpur");
		per.setPhonesinfo(Set.of(ph,ph1));
		
		try {
//			System.out.println(service.saveDataUsingParent(per));

			getAllPersonDetails();
			
//			System.out.println(service.deleteParentsNdItsChild(1002));
//			getAllPersonDetails();
			
			System.out.println(service.deleteOnlyPersonPhoneNumber(1002));
			getAllPersonDetails();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void getAllPersonDetails() {
		List<Person> list=service.loadDataUsingParent();
		list.forEach(person->{
			System.out.println("parent table row person ------------>"+person);
			if(person.getPhonesinfo().size() != 0) {
				person.getPhonesinfo().forEach(phoneNo->{
					System.out.println("child table row phone NO ----------->"+phoneNo);
				});
			}else {
				System.out.println("--------************---no phone number---*********************");
			}
		});
	}
}
