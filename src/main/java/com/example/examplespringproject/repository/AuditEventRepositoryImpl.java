package com.example.examplespringproject.repository;

import com.example.examplespringproject.model.PersistenceAuditEvent;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AuditEventRepositoryImpl implements AuditEventRepository {

    private final PersistenceAuditEventRepository persistenceAuditEventRepository;

    public AuditEventRepositoryImpl(PersistenceAuditEventRepository persistenceAuditEventRepository) {
        this.persistenceAuditEventRepository = persistenceAuditEventRepository;
    }

    @Override
    public List<AuditEvent> find(String principal, Instant after, String type) {
        return List.of();
    }

    @Override
    public void add(AuditEvent event) {
        WebAuthenticationDetails details = (WebAuthenticationDetails) event.getData().get("details");
        var auditEvent = PersistenceAuditEvent.builder()
                .principal(event.getPrincipal())
                .sessionId(details.getSessionId())
                .remoteAddress(details.getRemoteAddress())
                .requestUrl(event.getData().get("requestUrl") != null ? event.getData().get("requestUrl").toString() : "")
                .type(event.getType())
                .build();

        persistenceAuditEventRepository.save(auditEvent);
    }
}
