package com.example.examplespringproject.service;

import com.example.examplespringproject.exception.UserNotFoundException;
import com.example.examplespringproject.model.User;

public interface UserService {

    User save(User user);
    User getUserByEmail(String email) throws UserNotFoundException;
}
