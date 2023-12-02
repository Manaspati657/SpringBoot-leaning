package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private String empno;
	private String ename;
	private Long phone;
	private String mail;
	private Long salary;
	private String designation;
	
}
