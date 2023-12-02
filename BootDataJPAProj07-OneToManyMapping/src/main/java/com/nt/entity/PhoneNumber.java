package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@Entity
@Table(name="AM_PHONENUMBERS_DETAILS")
@Getter
@Setter
public class PhoneNumber implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer regNo;
	private Long phoneNumber;
	
	@Column(length=20)
	private String numberType;
	
	@Column(length=20)
	private String provider;
	
	@Override
	public String toString() {
		return "PhoneNumber(Child)[regNo="+regNo+",phoneNumber="+phoneNumber+
				",numberType="+numberType+",provider="+provider;
	}
	
	
}
