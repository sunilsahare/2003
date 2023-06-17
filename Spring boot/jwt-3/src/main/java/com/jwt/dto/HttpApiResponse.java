package com.jwt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpApiResponse {

	private String message;
	private String status;
	private Integer statusCode;

}
