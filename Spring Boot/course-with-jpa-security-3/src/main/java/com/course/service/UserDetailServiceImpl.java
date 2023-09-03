package com.course.service;

import com.course.entity.User;
import com.course.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(("Invalid email - "+email)));
    }

    @Override
    public User addUser(User user) {
        User save = userRepository.save(user);
        System.err.println("User: "+save);
        return save;
    }

    @Override
    public User updateUser(User user) {
        // Currently return existing user
        // Will update this code later
        return user;
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.delete(getUser(userId));
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid UserId - " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
