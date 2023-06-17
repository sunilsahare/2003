package com.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jwt.dto.HttpResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpResponse<Object>> exception(Exception ex) {
		HttpResponse<Object> response = HttpResponse.builder()
				.message(ex.getMessage())
				.status(HttpStatus.BAD_REQUEST.name())
				.reason("Failed")
				.responseData(new Object())
				.build();
		return ResponseEntity.ok(response);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<HttpResponse<Object>> badCredentialsExceptionHandler(BadCredentialsException exception) {
		HttpResponse<Object> response = HttpResponse.builder()
				.message(exception.getMessage())
				.status(HttpStatus.BAD_REQUEST.name())
				.reason("Failed")
				.responseData(new Object())
				.build();
		return ResponseEntity.ok(response);
	}
}
