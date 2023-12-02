package com.nt.restController;

import java.util.Collections;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Role;
import com.nt.entity.User;
import com.nt.payload.LoginDto;
import com.nt.payload.SignUpDto;
import com.nt.repository.IRoleRepository;
import com.nt.repository.IUserRepository;
import com.nt.service.JwtService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
//	swagger url
//	http://localhost:8086/registerApi/swagger-ui.html
//	password ---> password1 ,...
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/signin")
	@ApiOperation("Sign in api")
	public ResponseEntity<String> authenticateUser( @Valid @RequestBody LoginDto loginDto){
		String token="";
		try {
			Authentication authentication =authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginDto.getUsernameOrEmail(), loginDto.getPassword()
							));
			User user=userRepository.findByUsernameOrEmail(authentication.getName(),authentication.getName()).get();
			Set<Role> role=user.getRoles();
			role.forEach(rl->{
				System.out.println("role:: "+rl.getId());
			});
//			System.out.println(user);
//			System.out.println(role);
//			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			System.out.println(loginDto.getUsernameOrEmail());
			System.out.println(loginDto.getPassword());
			
			if(authentication.isAuthenticated())
			 token =jwtService.generateToken(loginDto.getUsernameOrEmail());
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.FORBIDDEN);
		} 
		
		return new ResponseEntity<String>("user signed in successfully!. token = "+token,HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpDto signupDto){
		
//		Add check for username exists in a DB
		if(userRepository.existsByUsername(signupDto.getUsername())) {
			return new ResponseEntity<String>("Username is already taken !",HttpStatus.BAD_REQUEST);
		}
		
//		add check for email exists in DB
		if(userRepository.existsByEmail(signupDto.getEmail())) {
			return new ResponseEntity<String>("Email is already taken !",HttpStatus.BAD_REQUEST);
		}
		
//		create user object
		User user=new User();
		user.setName(signupDto.getName());
		user.setUsername(signupDto.getUsername());
		user.setEmail(signupDto.getEmail());
		user.setPassword(passwordEncoder.encode(signupDto.getPassword()));
		
		Role roles =roleRepository.findByName("User").get();
		
		
		user.setRoles(Collections.singleton(roles));
		
		userRepository.save(user);
		return new ResponseEntity<String>("user registered successfully",HttpStatus.OK);
		
	}

}
