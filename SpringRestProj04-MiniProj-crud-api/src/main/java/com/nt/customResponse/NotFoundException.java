package com.nt.customResponse;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}

}
