package com.jwt.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enm.Role;
import com.jwt.exception.BusinessException;
import com.jwt.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JWTService implements UserDetailsService {

	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.jwt.models.User user = userRepository.findByUserId(username)
				.orElseThrow(() -> new BusinessException("User not found !!!"));
		return new User(username, user.getPassword(), getUserRoles(user.getRole()));

	}

	private Collection<? extends GrantedAuthority> getUserRoles(Role role) {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

}
