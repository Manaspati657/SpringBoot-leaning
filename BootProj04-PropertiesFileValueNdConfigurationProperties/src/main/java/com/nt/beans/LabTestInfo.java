package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("labInfo")
@Data
public class LabTestInfo {

	@Value("${lab.bpPrice}")
	private float bloadProfilePrice;
	
	@Value("${lab.rtpcrPrice}")
	private float rtpcrPrice;
	
	@Value("${lab.echo2DPrice}")
	private float echo2DPrice;
}
