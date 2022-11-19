package com.teja.control_advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teja.exceptions.CustomerNotFoundException;
import com.teja.pojo.CustomerNotFound;

@ControllerAdvice
public class CustomerAdvice {
	
	@ExceptionHandler
	public ResponseEntity customerNotFoundAdvice(CustomerNotFoundException e) {
		CustomerNotFound customerError = new CustomerNotFound();
		customerError.setErrorMessage(e.getMessage());
		customerError.setStatusCode(404);
		
		return new ResponseEntity(customerError,HttpStatus.NOT_FOUND);
		
	}

}
