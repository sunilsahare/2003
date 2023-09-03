package com.course.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }
}
