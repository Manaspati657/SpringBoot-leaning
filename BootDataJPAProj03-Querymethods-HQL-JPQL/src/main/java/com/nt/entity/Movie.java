package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@SuppressWarnings("serial")
@Data
@Entity
@Table(name="SP_DATA_MOVIE")
public class Movie implements Serializable {

	public Movie( String mname, String myear, Float rating) {
		super();
		this.mname = mname;
		this.myear = myear;
		this.rating = rating;
	}
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="MID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer mid;
	
	@Column(name="MNAME",length=20)
	private String mname;

	@Column(name="MYEAR",length=20)
	private String myear;
	
	@Column(name="RATING")
	private Float rating;
	
}
