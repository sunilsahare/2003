package com.jwt.service;

import java.util.List;

import com.jwt.dto.UserDto;

public interface UserService {

	public UserDto addUser(UserDto user);
	public List<UserDto> getUsers();
	public UserDto getUser(String userId);

}
