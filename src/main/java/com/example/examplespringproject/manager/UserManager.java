package com.example.examplespringproject.manager;

import com.example.examplespringproject.exception.UserNotFoundException;
import com.example.examplespringproject.model.User;

import java.util.List;

public interface UserManager {

    User save(User user);
    User getUserByEmail(String email) throws UserNotFoundException;
    List<User> getAllUsers();
}
