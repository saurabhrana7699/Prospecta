package com.masai.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(EntryException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(EntryException e, WebRequest req){

        ErrorDetails er = new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDate.now());
	        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
