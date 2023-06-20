package com.example.examplespringproject.service;

import com.example.examplespringproject.model.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Service
@CacheConfig(cacheNames={"userSessions"})
public class SessionServiceImpl implements SessionService {

    @Override
    @Cacheable(key = "#email", unless = "#result == null")
    public UserSession getUserSession(String email) {
        log.info("  Created new session for user: " + email);
        return UserSession.builder()
                .creationTime(Instant.now())
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    @CacheEvict(key = "#email")
    public void deleteSession(String email) {
        // This method will remove the user session from cache
    }
}
