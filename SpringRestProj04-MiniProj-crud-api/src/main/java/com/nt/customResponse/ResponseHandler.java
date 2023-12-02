package com.nt.customResponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHandler {
	
	public ResponseEntity<Object> generateResponse(String msg,HttpStatus status,Object responseObj){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("message", msg);
		map.put("status", status.value());
		if(responseObj != null)
     		map.put("data", responseObj);
		
		return new ResponseEntity<Object>(map,status);
	}

}
