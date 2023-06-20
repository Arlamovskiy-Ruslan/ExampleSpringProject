package com.example.examplespringproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Entity(name = "AuditEvent")
@NoArgsConstructor
public class PersistenceAuditEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "principal")
    private String principal;

    @Column(name = "type")
    private String type;

    @Column(name = "remoteAddress")
    private String remoteAddress;

    @Column(name = "sessionId")
    private String sessionId;

    @Column(name = "requestUrl")
    private String requestUrl;
}
