package com.nt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="employee")
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name="gen1",initialValue=1000,allocationSize=1,sequenceName="PID_SEQ1")
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer empno;
	
	@Column(length=20)
	private String ename;
	
	@Column(length=20)
	private String job;
	
	private Float sal;
	
}
