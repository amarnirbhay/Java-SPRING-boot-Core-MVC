package com.jsp.spring_boot_crud_with_response_exception.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.jsp.spring_boot_crud_with_response_exception.dto.ResponseStructure;

@ControllerAdvice
public class TeacherExceptionHandler {
	@Autowired
	ResponseStructure<String>  responseStructure;
	
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdFound(IdNotFoundException exception)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMsg("Data is Not available");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND.OK);
	}
}
