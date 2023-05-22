package com.example.examplespringproject.controller;

import com.example.examplespringproject.dto.UserRequest;
import com.example.examplespringproject.exception.UserNotFoundException;
import com.example.examplespringproject.model.User;
import com.example.examplespringproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/{email}")
    public User findByEmail(@PathVariable String email) throws UserNotFoundException {
        return userService.getUserByEmail(email);
    }

    @PostMapping(value = "/create", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody UserRequest userRequest) {
        var user = User.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(userRequest.getRoles())
                .createdBy(userRequest.getRoles())
                .modifiedBy(userRequest.getRoles())
                .build();

        return userService.save(user);
    }
}
