package com.code.ems.utils;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<RestErrorResponse> handleException(RecordNotFoundException exc){
		
		RestErrorResponse error = new RestErrorResponse(
										HttpStatus.NOT_FOUND.value(),
				 						exc.getMessage(),
				 						System.currentTimeMillis());		
		return new ResponseEntity<RestErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<RestErrorResponse> handleException(Exception exc){
		
		RestErrorResponse error = new RestErrorResponse(
										HttpStatus.BAD_REQUEST.value(),
				 						exc.getMessage(),
				 						System.currentTimeMillis());		
		return new ResponseEntity<RestErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex)  {

        Map<String, Object> body = new LinkedHashMap<String, Object>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        //Get all fields errors
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        
        System.out.println("handleMethodArgumentNotValid method: " + errors);

        body.put("errors", errors);

        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);

    }

}
