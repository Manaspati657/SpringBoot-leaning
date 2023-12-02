package com.nt.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.UserDto;
import com.nt.entity.User;
import com.nt.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
//		convert UserDto to User entity
		User user=new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		User savedUser=service.createUser(user);
				
//		convert User entity  to userDto class
		UserDto userResp=new UserDto();
		userResp.setName(savedUser.getName());
		userResp.setEmail(savedUser.getEmail());
		userResp.setId(savedUser.getId());
		
		return new ResponseEntity<UserDto>(userResp,HttpStatus.CREATED);
		
		
	}

}
