package com.example.examplespringproject.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class UserSession {

    private UUID uuid;
    private Instant creationTime;

}
