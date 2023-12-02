
package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validations.EmployeeValidator;

@Controller
public class EmployeeOperationsController {

	@Autowired IEmployeeMgmtService service;
	@Autowired EmployeeValidator empValidator;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public String showEmployeeReport(Map<String,Object> map) {
		//use service
		List<Employee> list=service.getAllEmployees();
		
		//put the results in model attributes
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}
	
	@GetMapping("/add")
	public String showAddEmploeeForm(@ModelAttribute("emp") Employee emp) {
//		emp.setJob("Software Developer");//initial value to display in form component as initial value
//		return LVN
		return "employee_register";
	}
	
	@PostMapping("/add")
//	public String addEmployee(Map<String,Object> map,@ModelAttribute("emp") Employee emp) {
//	public String addEmployee(HttpSession session,@ModelAttribute("emp") Employee emp) {
    public String addEmployee(RedirectAttributes attr,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		//use service
		String result=service.registerEmployee(emp);
		
		if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_register";
		}
		
//		List<Employee> list=service.getAllEmployees();
//		map.put("resultMsg", result);
//		map.put("empsData", list);
//		System.out.println(list);
		
//		session.setAttribute("resultMsg", result);
		
		attr.addFlashAttribute("resultMsg", result);
		
		//return LVN
//		return "employee_report";
		return "redirect:report";
	}
	
	
	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
		
		Employee emp1=service.getEmployeeByNo(no);
		
		//emp =emp1
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
	}
	
	@PostMapping("/edit")
//	public String editEmployee(Map<String,Object> map,@ModelAttribute("emp") Employee emp) {
//	public String editEmployee(HttpSession session,@ModelAttribute("emp") Employee emp) {
	public String editEmployee(RedirectAttributes attr,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		//use service
		String result=service.editEmployee(emp);
		

		if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_register";
		}
		
//		List<Employee> list=service.getAllEmployees();
//		map.put("resultMsg", result);
//		map.put("empsData", list);
//		System.out.println(list);
		
//		session.setAttribute("resultMsg", result);
		
		attr.addFlashAttribute("resultMsg", result);
		
		//return LVN
//		return "employee_report";
		return "redirect:report";
		
	}
	
	@GetMapping("/delete")
//	public String deleteEmployeee(@RequestParam("no") int no,Map<String,Object> map) {
//	public String deleteEmployeee(@RequestParam("no") int no,HttpSession session) {
	public String deleteEmployeee(@RequestParam("no") int no,RedirectAttributes attr) {
		
		String msg=service.deleteEmployee(no);
		
//		List<Employee> list=service.getAllEmployees();
//		
//		//keep result in model attributes 
//		
//		map.put("resultMsg", msg);
//		map.put("empsData", list);
		
		
//		session.setAttribute("resultMsg", msg);
		
		attr.addFlashAttribute("resultMsg", msg);
		
		//return LVN
//		return "employee_report";
		return "redirect:report";
	}
}



























