package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
@Data
public class Hospital {
	
	//collecting from properties file
	@Value("${hospital.name}")
	private String hospitalName;
	
	@Value("${hospital.age}")
	private int rank;
	
	//hard coded value
	@Value("KIMS")
	private String hospitalName1;
	
	@Value("25")
	private int rank1;
	
	//injecting from environment variable 
	@Value("${Path}")
	private String pathData;
	
	//injecting from system properties value 
	@Value("${os.name}")
    private String os;
	
	//@Autowired //autowiring 
	@Value("#{labInfo}")  //using Spring Expression language (SPEL) proforming injection to object type properties
	private LabTestInfo info;
	
	@Value("#{labInfo.rtpcrPrice+labInfo.echo2DPrice}")
    private float labtestBillAmount;
	
}





























