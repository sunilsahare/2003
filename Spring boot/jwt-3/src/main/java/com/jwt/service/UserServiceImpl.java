package com.jwt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jwt.DtoUtil.UserDtoHeper;
import com.jwt.dto.UserDto;
import com.jwt.exception.BusinessException;
import com.jwt.models.User;
import com.jwt.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public List<UserDto> getUsers() {
		return UserDtoHeper.convertToDTOList(userRepository.findAll());
	}

	@Override
	public UserDto addUser(UserDto user) {
		User userToBeSaved = UserDtoHeper.userDtoToEntity(user);
		System.err.println(userToBeSaved);
		boolean isUserExists = userRepository.findByUserId(userToBeSaved.getUserId()).isPresent();
		if (isUserExists)
			throw new BusinessException("Please choose another userId !!!");

		User savedUser = userRepository.save(userToBeSaved);
		UserDto savedUserDto = UserDtoHeper.userEntityToDto(savedUser);
		return savedUserDto;
	}

	@Override
	public UserDto getUser(String userId) {
		User user = userRepository.findByUserId(userId)
				.orElseThrow(() -> new BusinessException("User not found. Invalid userId '" + userId + "'"));
		return UserDtoHeper.userEntityToDto(user);
	}

}
