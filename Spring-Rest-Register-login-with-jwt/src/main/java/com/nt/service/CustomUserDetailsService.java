package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username+"-----------------------");
		Optional<User> user = repository.findByUsername(username);
		CustomUserDetails userDetails = null;
		if (user != null) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user.get());
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return userDetails;

	}
	

}
