package com.example.examplespringproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String email;
    private String password;
    private String roles;

}
