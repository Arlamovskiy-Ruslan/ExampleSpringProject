package com.example.examplespringproject.service.cache;

import com.example.examplespringproject.model.User;
import com.example.examplespringproject.model.UserSession;
import com.example.examplespringproject.service.SessionService;
import com.example.examplespringproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CacheValidatorService {

    private final UserService userService;
    private final SessionService sessionService;
    private final CacheManager cacheManager;

    @Scheduled(fixedRate = 30000)
    public void evictExpiredUserSessions() {
        Cache userSessions = cacheManager.getCache("userSessions");
        userService.getAllUsers().stream()
                .map(User::getEmail)
                .forEach(email -> Optional.ofNullable(userSessions.get(email, UserSession.class))
                            .filter(session -> session.getCreationTime().isBefore(Instant.now().minus(5, ChronoUnit.MINUTES)))
                            .ifPresent(session -> sessionService.deleteSession(email))
                );
    }
}
