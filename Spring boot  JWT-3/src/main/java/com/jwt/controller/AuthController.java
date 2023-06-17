package com.jwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.dto.HttpResponse;
import com.jwt.dto.JwtRequest;
import com.jwt.dto.UserDto;
import com.jwt.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	private Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/authenticate")
	public ResponseEntity<HttpResponse<Object>> authenticate(@RequestBody JwtRequest request) {
		HttpResponse<Object> response = HttpResponse.builder()
				.message("User Successfully Authenticated")
				.status("SUCCESS")
				.responseData(userService.authenticate(request))
				.build();
		logger.info("'{}' User successfully authenticated.",request.getEmail());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody UserDto uerDto) {
		UserDto savedUser = userService.saveUser(uerDto);
		logger.info("'{}' User successfully registered.",uerDto.getEmail());
		HttpResponse<Object> response = HttpResponse.builder()
				.message("User Successfully registered.")
				.status("SUCCESS")
				.responseData(savedUser)
				.build();
		return ResponseEntity.ok(response);
	}

}
