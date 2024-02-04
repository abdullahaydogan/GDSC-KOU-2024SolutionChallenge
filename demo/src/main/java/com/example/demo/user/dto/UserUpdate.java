package com.example.demo.user.dto;

import com.example.demo.user.exception.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


public record UserUpdate(
        String username,
        String phoneNumber,
        @Email
        @UniqueEmail
        String email,

        @Size(min = 6)
        String password,

        String city,
        String longitude,
        String latitude


) {

}
