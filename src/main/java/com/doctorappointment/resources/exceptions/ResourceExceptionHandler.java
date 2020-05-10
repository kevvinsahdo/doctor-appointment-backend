package com.doctorappointment.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.doctorappointment.services.exceptions.UserConflictException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(UserConflictException.class)
	public ResponseEntity<?> userCOnflict(UserConflictException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}
}
