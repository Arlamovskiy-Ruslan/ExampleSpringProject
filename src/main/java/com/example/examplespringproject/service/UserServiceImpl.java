package com.example.examplespringproject.service;

import com.example.examplespringproject.exception.UserNotFoundException;
import com.example.examplespringproject.manager.UserManager;
import com.example.examplespringproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserManager userManager;

    @Override
    public User save(User user) {
        return userManager.save(user);
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        return userManager.getUserByEmail(email);
    }
}
