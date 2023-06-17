package com.jwt.service;

import java.util.List;

import com.jwt.dto.JwtRequest;
import com.jwt.dto.JwtResponse;
import com.jwt.dto.UserDto;

public interface UserService {

	public List<UserDto> getUsers();

	public UserDto saveUser(UserDto userDto);

	public JwtResponse authenticate(JwtRequest request);

}
