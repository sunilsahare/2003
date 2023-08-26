package com.employee.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
