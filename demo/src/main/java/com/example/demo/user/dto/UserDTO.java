package com.example.demo.user.dto;


import com.example.demo.user.User;
import lombok.Data;

@Data
public class UserDTO {

    int id;

    String name;

    String surname;

    String phoneNumber;

    String email;

    String city;

    String latitude;

    String longitude;

    public UserDTO(User user) {
        setId(user.getId());
        setName(user.getName());
        setSurname(user.getSurname());
        setPhoneNumber(user.getPhoneNumber());
        setEmail(user.getEmail());
        setCity(user.getCity());
        setLatitude(user.getLatitude());
        setLongitude(user.getLongitude());
    }

}
