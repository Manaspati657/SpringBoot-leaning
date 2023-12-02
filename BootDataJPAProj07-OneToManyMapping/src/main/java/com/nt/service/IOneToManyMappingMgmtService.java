package com.nt.service;

import java.util.List;

import com.nt.entity.Person;

public interface IOneToManyMappingMgmtService {

	public String saveDataUsingParent(Person person);
	
	public List<Person> loadDataUsingParent();
	
	public String deleteParentsNdItsChild(int pid);
	
	public String deleteOnlyPersonPhoneNumber(int pid);

}
