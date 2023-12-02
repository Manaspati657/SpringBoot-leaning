package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}

}
