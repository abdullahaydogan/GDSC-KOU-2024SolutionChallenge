package com.example.demo.error;

import com.example.demo.user.exception.InvalidTokenException;
import com.example.demo.user.exception.NotUniqueEmailException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodArgNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("Validation Error");
        Map<String, String> validationError = new HashMap<>();
        for (var fieldError : exception.getBindingResult().getFieldErrors()) {
            validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationError);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(NotUniqueEmailException.class)
    ResponseEntity<ApiError> handleNotUniqEmailException(NotUniqueEmailException exception,
                                                         HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("Validation Error");
        Map<String, String> validationError = new HashMap<>();
        validationError.put("email", "E-mail in use");
        apiError.setValidationErrors(validationError);
        return ResponseEntity.badRequest().body(apiError);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ApiError> handleEntityNotFoundException(EntityNotFoundException exception, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(404);
        apiError.setPath(request.getRequestURI());
        apiError.setMessage("Not Found");
        Map<String, String> validationError = new HashMap<>();
        apiError.setValidationErrors(validationError);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    ResponseEntity<ApiError> handleAuthenticatonException(AuthenticationException authenticationException, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setPath(request.getRequestURI());
        apiError.setStatus(401);
        apiError.setMessage(authenticationException.getMessage());
        return ResponseEntity.status(401).body(apiError);
    }

    @ExceptionHandler(InvalidTokenException.class)
    ResponseEntity<ApiError> handleInvalidTokenException(InvalidTokenException invalidTokenException, HttpServletRequest request) {
        ApiError apiError = new ApiError();
        apiError.setPath(request.getRequestURI());
        apiError.setStatus(400);
        apiError.setMessage(invalidTokenException.getMessage());
        return ResponseEntity.status(400).body(apiError);
    }

}
