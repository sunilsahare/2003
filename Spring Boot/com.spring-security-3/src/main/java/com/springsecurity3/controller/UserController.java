package com.springsecurity3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity3.modal.User;

@RestController
@RequestMapping("/user/")
public class UserController {

	private List<User> users;

	public UserController() {
		users = new ArrayList<>();
		User user1 = User.builder().name("Sunil Sahare").email("sunil@abc.com").userId("sunil").password("sunil")
				.build();
		User user2 = User.builder().name("Trishul").email("trishul@abc.com").userId("trishul").password("trishul")
				.build();
		User user3 = User.builder().name("Shubham Thorat").email("shubh@abc.com").userId("shubh").password("trishul")
				.build();
		users.add(user1);
		users.add(user2);
		users.add(user3);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser() {
		return ResponseEntity.ok(users);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<User>> addUser(@RequestBody User user) {
		users.add(user);
		return ResponseEntity.ok(users);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
		User existingUser = users.stream().filter(u -> u.getUserId().equalsIgnoreCase(user.getUserId())).findFirst()
				.orElseThrow(() -> new Exception("User not found"));
		existingUser.setEmail(user.getEmail());
		existingUser.setName(user.getName());
		existingUser.setPassword(user.getPassword());
		System.err.println("All Users: " + users);
		return ResponseEntity.ok(existingUser);
	}

	@RequestMapping(value = "{userid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userid") String userId) throws Exception {
		User existingUser = users.stream().filter(u -> u.getUserId().equalsIgnoreCase(userId)).findFirst()
				.orElseThrow(() -> new Exception("User not found"));
		users.remove(existingUser);
		System.err.println("All Users: " + users);
		return ResponseEntity.ok("User '" + userId + "' succesfully deleted.");
	}

}
