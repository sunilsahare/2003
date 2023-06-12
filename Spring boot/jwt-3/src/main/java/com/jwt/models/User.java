package com.jwt.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class User {

	private String userId;
	private String name;
	private String email;
	
}
