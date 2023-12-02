package com.nt.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.User;
import com.nt.repository.IUserRepository;

@RestController
@RequestMapping("/secure/auth/")
public class AdminController {
	
	@Autowired private IUserRepository userRepository;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/*@PreAuthorize("hasAnyRole('Admin')")*/
	@PostMapping("user/add")
	public String addUserByAdmin(@RequestBody User user) {
		
		String pwd=user.getPassword();
		String encryptPwd=bCryptPasswordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		userRepository.save(user);
		
		
		return "User added successfully";
	}
	
	@PreAuthorize("hasAnyRole('Admin')")
	@GetMapping("admin/all")
	public String securedHello() {
		return "Secured Hello";
	}

}
