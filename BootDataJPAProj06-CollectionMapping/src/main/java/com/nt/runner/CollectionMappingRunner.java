package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;

@Component
public class CollectionMappingRunner implements CommandLineRunner{

	@Autowired IEmployeeMgmtService service;
	
	@Override
	public void run(String ...args) {
		
//		save object
		try {
//			prepare object
			EmployeeInfo info= new EmployeeInfo(21,"liza",
					List.of("rupa","mili","kuni"),
					Set.of(885621245L,8956563154L),
					Map.of("aadhar","5623 4578 5454","voterId","785421"));
			System.out.println(service.registerEmployee(info));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("========all emp ---details are-------------");
		service.getAllEmpDetails().forEach(System.out::println);
	}
}

