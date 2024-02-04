package com.example.demo.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User {

    @Id
    @GeneratedValue
    int id;
    @NotBlank
    String username;
    @NotBlank
    String name;
    @NotBlank
    String surname;
    @NotBlank
    String phoneNumber;
    @NotBlank
    String city;
    @NotBlank
    @Email
    String email;
    @NotBlank
    // @JsonIgnore //Does not send data to client
    @Size(min = 6)
    String password;
    // @JsonIgnore // Does not send data to client
    boolean active = false;
    // @JsonIgnore // Does not send data to client
    String activationToken;
    @NotBlank
    String longitude;
    @NotBlank
    String latitude;


}
