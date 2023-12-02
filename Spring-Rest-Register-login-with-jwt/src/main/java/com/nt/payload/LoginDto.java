package com.nt.payload;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginDto {
	
	@NotBlank(message="Username shouldn't be null or empty.")
	@Size(min=8,message="Username should have atleast 2 characters.")
	private String usernameOrEmail;
	
	@NotBlank(message="Password shouldn't be null or empty.")
	@Size(min = 8 ,message="password should have at least 8 characters")
	@Size(max = 18 ,message="password should have minimum of 18 characters")
	private String password;

}