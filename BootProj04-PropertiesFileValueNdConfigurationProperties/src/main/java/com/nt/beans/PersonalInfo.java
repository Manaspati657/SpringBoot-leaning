package com.nt.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="per.info")
@Component("pInfo")
public class PersonalInfo {

	//symple/wrapper type
	private Integer pid;
	private String pname;
	
	//array type
	private String[] favColors;
	
	//List-collection type
	private List<String> studies;
	
	//set-collection type
	private Set<Long> phoneNumbers;
	
	//Map-Collection type
	private Map<String,Object> idDetails;
	
	//Has-A type (composition)
	private JobDetails jobInfo;
	
	@Override
	public String toString() {
		return "Personal info:: [pid="+pid+",pname="+pname+",favColors="+Arrays.toString(favColors)+
				",studies="+studies+",phoneNumbers="+phoneNumbers+",idDetials="+idDetails+",jobInfo="+jobInfo+"]";
	}
	
}


































