package com.jwt.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private String role;

}
