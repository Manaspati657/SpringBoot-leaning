package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BOOT_JS_INFO")
@Data 
public class JobSeekerInfo implements Serializable {
	
	@Id
	@SequenceGenerator(name="gen1",initialValue=1000,allocationSize=1,sequenceName="PID_SEQ1")
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer jsId;
	
	@Column(length=15)
	private String jsName;
	
	@Column(length=15)
	private String jsAddrs;
	
	@Column(length=20)
	private String resumePath;
	
	@Column(length=20)
	private String photoPath;

}
