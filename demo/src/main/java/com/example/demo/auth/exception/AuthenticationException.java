package com.example.demo.auth.exception;


import com.example.demo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super(Messages.getMessageForLocale("demo.auth.invalid.credentials", LocaleContextHolder.getLocale()));
    }
}
