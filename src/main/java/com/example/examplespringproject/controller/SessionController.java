package com.example.examplespringproject.controller;

import com.example.examplespringproject.dto.UserSessionResponse;
import com.example.examplespringproject.mapper.SessionMapper;
import com.example.examplespringproject.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/session")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    @GetMapping("/{email}")
    public UserSessionResponse getSession(@PathVariable String email) {
        return sessionMapper.toResponse(sessionService.getUserSession(email));
    }
}
