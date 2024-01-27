package com.example.demo.error;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class ApiError {

    private final long timestamp = new Date().getTime();
    private Map<String, String> validationErrors = new HashMap<>();
    private int status;
    private String message;
    private String path;


}
