package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repo.IPersonRepo;
import com.nt.repo.IPhoneNumberRepo;

@Service("otmService")
public class OneToManyMappingMgmtServiceImpl implements IOneToManyMappingMgmtService {
	
	@Autowired IPersonRepo personRepo;
	@Autowired IPhoneNumberRepo phoneRepo;
	
	@Override
	public String saveDataUsingParent(Person person) {
		return personRepo.save(person).getPid()+" person is saved";
	}

	@Override
	public List<Person> loadDataUsingParent(){
		return personRepo.findAll();
	}
	
	@Override
	public String deleteParentsNdItsChild(int pid) {
		
		//load parent object
		Optional<Person> opt=personRepo.findById(pid);
		if(opt.isPresent()) {
			personRepo.delete(opt.get()); //if we delete the parent object associate child object automatic delete 
//			becase we have set cascadeType as ALL
			return "person and his phonenumbers are deleted";
		}
		else {
			return "*********************************--Person not found--**************************************";
		}	
	}
	
	@Override
	public String deleteOnlyPersonPhoneNumber(int pid) {
		
		Optional<Person> opt=personRepo.findById(pid);
		if(opt.isPresent()) {
			Set<PhoneNumber> childs=opt.get().getPhonesinfo();
//			childs.forEach(phone->{
//				phoneRepo.delete(phone);
//			});
			if(childs.size() != 0) {
				phoneRepo.deleteAll(childs);
				return "All child phone number of a person is deleted";
			}else {
				return "*********************************--Person has no phone number--**************************************";
			}
			
		}else {
			return "*********************************--Person not found--**************************************";
		}
	}
	
	
	
}






















