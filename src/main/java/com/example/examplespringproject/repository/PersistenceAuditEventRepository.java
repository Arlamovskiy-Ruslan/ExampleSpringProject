package com.example.examplespringproject.repository;

import com.example.examplespringproject.model.PersistenceAuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistenceAuditEventRepository extends JpaRepository<PersistenceAuditEvent, Long> {
}
