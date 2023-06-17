package com.jwt.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jwt.dto.UserDto;
import com.jwt.models.User;

public class UserHelper {

	public static UserDto entityToDto(User savedUser) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(savedUser, userDto);
		return userDto;
	}

	public static User dtoToEntity(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return user;
	}

	public static List<UserDto> entityListToDtos(List<User> users) {
		List<UserDto> dtoList = new ArrayList<>();
		users.forEach(user -> dtoList.add(entityToDto(user)));
		return dtoList;
	}
	
	public static List<User> dtoToEntityList(List<UserDto> userDto) {
		List<User> userList = new ArrayList<>();
		userDto.forEach(dto -> userList.add(dtoToEntity(dto)));
		return userList;
	}
	
}
