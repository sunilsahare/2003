package com.jwt.DtoUtil;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.jwt.dto.UserDto;
import com.jwt.models.User;

public class UserDtoHeper {

	public static List<UserDto> convertToDTOList(List<User> users) {
		return users.stream().map(user -> userEntityToDto(user)).collect(Collectors.toList());
	}

	public static UserDto userEntityToDto(User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

	public static User userDtoToEntity(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return user;
	}

}
