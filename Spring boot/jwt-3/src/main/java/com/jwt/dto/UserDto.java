package com.jwt.dto;

import java.util.List;

import com.enm.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private Long rowId;
	private String userId;
	private String name;
	private String email;
	private String password;
	private String address;
	private String mobileNo;
	@Enumerated(EnumType.STRING)
	private Role role;

}