package com.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jwt.dto.HttpApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<HttpApiResponse> jwtCustomException(BusinessException jwt) {
		HttpApiResponse response = HttpApiResponse.builder().message(jwt.getMessage())
				.status(HttpStatus.BAD_REQUEST.toString()).build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpApiResponse> globalException(Exception e) {
		HttpApiResponse response = HttpApiResponse.builder().message(e.getMessage())
				.status(HttpStatus.BAD_REQUEST.toString()).build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
