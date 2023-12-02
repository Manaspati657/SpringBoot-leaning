package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ACTOR")
public class Actor {
	
	@Id
	@SequenceGenerator(name="gen1",initialValue=1000,allocationSize=1,sequenceName="PID_SEQ1")
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer actorid;
	
	@Column(length=20)
	private String actorname;
	
	@Column(length=20)
	private String category;
	
	private Long mobileNo;
	

}
