package com.example.examplespringproject.exception;

public abstract class ExampleSpringProjectException extends Exception {

    public ExampleSpringProjectException() {
    }

    public ExampleSpringProjectException(String message) {
        super(message);
    }

    public ExampleSpringProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExampleSpringProjectException(Throwable cause) {
        super(cause);
    }

    public ExampleSpringProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    abstract public int getHttpStatusCode();
}
