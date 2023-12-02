package com.nt.customResponse;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.model.ErrorDetails;

@RestControllerAdvice
public class ActorControlAdvice {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException nfe){
		System.out.println("**************ActorControlAdvice.handleNotFoundException()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),nfe.getMessage(),"500");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e){
		System.out.println("**************ActorControlAdvice.handleAllException()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(), e.getMessage(), "500");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
