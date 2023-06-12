package com.jwt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.models.User;
import com.jwt.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		System.out.println("Fetching users from db");
		return ResponseEntity.ok(userService.getUsers());
	}

	@GetMapping("/loginUser")
	public ResponseEntity<String> getLoggedInUsers(Principal principal) {
		return ResponseEntity.ok(principal.getName());
	}
}
