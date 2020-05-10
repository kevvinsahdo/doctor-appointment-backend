package com.doctorappointment.services.exceptions;

public class UserConflictException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UserConflictException(String message) {
		super(message);
	}

}
