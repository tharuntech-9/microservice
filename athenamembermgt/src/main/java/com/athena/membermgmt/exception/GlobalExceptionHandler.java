package com.athena.membermgmt.exception;

import java.util.Date;

import org.apache.http.HttpException;
import org.apache.http.client.HttpResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(PolicyMemberNotFoundException.class)
	public ResponseEntity<?> handlePolicyMemberNotFoundException(PolicyMemberNotFoundException exception,WebRequest request,HttpResponseException httpResponseException){
		
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false),httpResponseException.getStatusCode() );
		
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(PolicyMemberNotFoundException exception,WebRequest request,HttpResponseException httpResponseException){
		
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false),httpResponseException.getStatusCode());
		
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
