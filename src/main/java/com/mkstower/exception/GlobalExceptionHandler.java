package com.mkstower.exception;

import java.util.*;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
		
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
							MethodArgumentNotValidException ex,
							HttpHeaders headers, 
							HttpStatusCode status, 
							WebRequest request
							) {
		Map<String, String> errors = new HashMap<>();
		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
		
		errorList.forEach( error -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
