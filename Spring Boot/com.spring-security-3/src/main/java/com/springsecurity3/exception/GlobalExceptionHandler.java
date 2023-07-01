package com.springsecurity3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springsecurity3.modal.HttpResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpResponse> exception(Exception e) {
		HttpResponse httpResponse = HttpResponse.builder().message(e.getMessage())
				.errorCode(HttpStatus.BAD_REQUEST.name()).build();
		return new ResponseEntity<>(httpResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<HttpResponse> businessException(BusinessException e) {
		HttpResponse httpResponse = HttpResponse.builder().message(e.getMessage())
				.errorCode(HttpStatus.BAD_REQUEST.name()).build();
		return new ResponseEntity<>(httpResponse, HttpStatus.BAD_REQUEST);
	}
}
