package com.course.service;

import com.course.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomUserDetailsService extends UserDetailsService {

    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(Integer userId);
    public User getUser(Integer userId);
    public List<User> getAllUsers();
}
