package com.example.demo.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Forbidden");
    }
}
