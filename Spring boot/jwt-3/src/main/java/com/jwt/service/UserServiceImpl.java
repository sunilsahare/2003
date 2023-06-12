package com.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.models.User;

@Service
public class UserServiceImpl implements UserService {

	private List<User> users = new ArrayList<>();
	
	public UserServiceImpl() {
		users.add(User.builder().userId(UUID.randomUUID().toString()).name("Sunil Shaare").email("sunil.sahare@ss.com").build());
		users.add(User.builder().userId(UUID.randomUUID().toString()).name("Trishul Ingle").email("trishul@ss.com").build());
		users.add(User.builder().userId(UUID.randomUUID().toString()).name("Akshay").email("akshay@ss.com").build());
	}

	@Override
	public List<User> getUsers() {
		return this.users;
	}
}
