package com.springsecurity3.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
}
