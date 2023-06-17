package com.jwt.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.dto.JwtRequest;
import com.jwt.dto.JwtResponse;
import com.jwt.dto.UserDto;
import com.jwt.models.Role;
import com.jwt.models.User;
import com.jwt.repo.UserRepository;
import com.jwt.security.JwtHelper;
import com.jwt.util.UserHelper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final PasswordEncoder encoder;
	private final UserRepository userRepository;
	private final JwtHelper jwtHelper;
	private final AuthenticationManager authenticationManager;
	
	@Override
	public List<UserDto> getUsers() {
		List<User> userList = userRepository.findAll();
		return UserHelper.entityListToDtos(userList);
	}
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = User.builder()
		.email(userDto.getEmail())
		.role(Role.USER)
		.firstname(userDto.getFirstname())
		.lastname(userDto.getLastname())
		.password(encoder.encode(userDto.getPassword()))
		.build();
		
		User savedUser = userRepository.save(user);
//		String token = jwtHelper.generateToken(user);
		UserDto savedUserDto = UserHelper.entityToDto(savedUser);
		return savedUserDto;
	}
	
	@Override
	public JwtResponse authenticate(JwtRequest request) {
		authenticationManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(
								request.getEmail(),
								request.getPassword()
						)
				);
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		String jwtToken = jwtHelper.generateToken(user);
		return JwtResponse.builder().jwtToken(jwtToken).build();
	}
}
