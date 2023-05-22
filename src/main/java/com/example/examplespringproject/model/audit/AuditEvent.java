package com.example.examplespringproject.model.audit;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AuditEvent<T> extends ApplicationEvent {

    private T data;

    public AuditEvent(T event) {
        super(event);
    }
}
