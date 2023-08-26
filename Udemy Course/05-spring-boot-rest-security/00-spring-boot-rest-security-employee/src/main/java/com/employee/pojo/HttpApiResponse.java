package com.employee.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HttpApiResponse {

    private int status;
    private String message;
    private long timestamp;

}
