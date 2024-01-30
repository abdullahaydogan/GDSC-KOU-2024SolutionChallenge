package com.example.demo.user.exception;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException() {
        super("Forbidden");
    }
}
