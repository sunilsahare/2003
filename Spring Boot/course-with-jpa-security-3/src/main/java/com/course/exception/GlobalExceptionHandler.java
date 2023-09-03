package com.course.exception;

import com.course.dto.HttpApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<HttpApiResponse> courseException(CourseNotFoundException exception) {
        HttpApiResponse response = HttpApiResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpApiResponse> exception(Exception exception) {
        HttpApiResponse response = HttpApiResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(System.currentTimeMillis())
                .build();
        System.err.println(exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
