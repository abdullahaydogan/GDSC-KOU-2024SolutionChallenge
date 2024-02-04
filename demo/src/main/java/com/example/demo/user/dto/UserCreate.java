package com.example.demo.user.dto;

import com.example.demo.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreate(
        @NotBlank String username,
        @NotBlank String name,
        @NotBlank String surname,
        @NotBlank String phoneNumber,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6) String password,

        @NotBlank String city,

        String longitude,
        String latitude

) {

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phoneNumber);
        user.setCity(city);
        user.setLongitude(longitude);
        user.setLatitude(latitude);

        return user;
    }

}
