package com.example.demo.user.dto;

import com.example.demo.user.User;
import com.example.demo.user.validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreate(
        @NotBlank
        @Size(min = 4)
        String username,
        @NotBlank
        @Email
        @UniqueEmail
        String email,
        @NotBlank
        @Size(min = 4)
        String password
) {

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }


}
