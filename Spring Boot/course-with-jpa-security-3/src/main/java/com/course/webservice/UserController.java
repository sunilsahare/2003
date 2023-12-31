package com.course.webservice;

import com.course.entity.User;
import com.course.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class UserController {

    private final CustomUserDetailsService userDetailsService;

    private final BCryptPasswordEncoder encoder;

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        // Id is autogenerated, therefore we will not accept the userId as input
        user.setId(0);
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(userDetailsService.addUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userDetailsService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userDetailsService.getUser(userId));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable Integer userId) {
        userDetailsService.deleteUser(userId);
        return ResponseEntity.ok("User Successfully Deleted.");
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer userId, @RequestBody User user) {
        user.setId(userId);
        return ResponseEntity.ok(userDetailsService.updateUser(user));
    }

    @GetMapping("userinfo")
    public Authentication getUserInfo(Authentication authentication) {
        return authentication;
    }

}
