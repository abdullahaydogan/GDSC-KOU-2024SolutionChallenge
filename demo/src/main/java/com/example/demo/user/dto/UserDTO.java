package com.example.demo.user.dto;


import com.example.demo.user.User;
import lombok.Data;

@Data
public class UserDTO {

    int id;
    String username;

    String name;

    String surname;

    String phoneNumber;

    String email;

    String city;

    String latitude;

    String longitude;
    String activationToken;
    String password;

    public UserDTO(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setName(user.getName());
        setSurname(user.getSurname());
        setPhoneNumber(user.getPhoneNumber());
        setEmail(user.getEmail());
        setCity(user.getCity());
        setLatitude(user.getLatitude());
        setLongitude(user.getLongitude());
        setPassword(user.getPassword());
        setActivationToken(user.getActivationToken());
    }

}
