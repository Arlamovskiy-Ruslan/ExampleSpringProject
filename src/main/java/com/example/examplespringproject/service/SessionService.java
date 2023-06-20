package com.example.examplespringproject.service;

import com.example.examplespringproject.model.UserSession;

public interface SessionService {

    UserSession getUserSession(String email);

    void deleteSession(String email);
}
