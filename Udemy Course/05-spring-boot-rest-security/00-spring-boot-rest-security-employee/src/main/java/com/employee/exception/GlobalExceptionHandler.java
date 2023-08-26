package com.employee.exception;

import com.employee.pojo.HttpApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<HttpApiResponse> exception(EmployeeNotFoundException exception) {
        return new ResponseEntity<>(
                HttpApiResponse.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(exception.getMessage())
                        .timestamp(System.currentTimeMillis())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpApiResponse> exception(Exception exception) {
        return new ResponseEntity<>(
                HttpApiResponse.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(exception.getMessage())
                        .timestamp(System.currentTimeMillis())
                .build(), HttpStatus.BAD_GATEWAY);
    }

}
