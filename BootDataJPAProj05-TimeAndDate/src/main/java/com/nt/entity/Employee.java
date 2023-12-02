package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer empid;
	public String ename;
	public float eage;
	public LocalDate dob;
	public LocalTime tob;
	public LocalDateTime doj;
	

}
