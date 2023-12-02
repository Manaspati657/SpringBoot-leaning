package com.nt.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {

	private long id;
	
	// user name should not be null or empty
	// user name should have at least 2 characters
	@NotBlank(message="user name should not be empty ")
	@NotEmpty(message="user name should not be null")
	@Size(min=2,message="user name should have at least 2 characters")
	private String name;
	
	// email should be a valid email format
	// email should not be null or empty
	@NotEmpty(message="email should be a valid email format")
	@Email(message="mail should be in right format")
	private String email;
	
	// password should not be null or empty
	// password should have at least 8 characters
	@NotEmpty(message="password should not be null or empty")
	@Size(min = 8 ,message="password should have at least 8 characters")
	@Size(max = 18 ,message="password should have minimum of 18 characters")
	private String password;
	
	
	
	
	
}
