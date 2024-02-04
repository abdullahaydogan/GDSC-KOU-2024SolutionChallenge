package com.example.demo.user.exception;

import com.example.demo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException() {
        super(Messages.getMessageForLocale("Solution.activate.invalid.token", LocaleContextHolder.getLocale()));
    }

}
