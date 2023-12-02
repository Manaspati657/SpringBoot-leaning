package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {

	
	@GetMapping("/")
	public String showHomePage() {
		//return LVN (home page --welcome.jsp)
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showStudentFormPage(@ModelAttribute("stud") Student st) {
//		return LVN (form page-student-register.jsp
		st.setAvg(1.0f);
		return "student_register";
	}
	
	@PostMapping("/register")
	public String registerStudent(Map<String,Object> map,
			          @ModelAttribute Student st) {
		System.out.println(st);
		return "show_result";
	}
	
}
