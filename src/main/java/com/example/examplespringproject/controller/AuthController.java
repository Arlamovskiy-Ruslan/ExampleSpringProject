package com.example.examplespringproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
    @RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping(value = "/login")
    public String login() {
        return "Hello World!!!";
    }
}
