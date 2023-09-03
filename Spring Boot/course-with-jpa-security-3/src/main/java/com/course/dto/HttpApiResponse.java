package com.course.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class HttpApiResponse {
    private int status;
    private String message;
    private long timestamp;
}
