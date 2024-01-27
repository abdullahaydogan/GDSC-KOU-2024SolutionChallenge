package com.example.demo.user;

import com.example.demo.user.validation.UniqueEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User {

    @Id
    @GeneratedValue
    long id;
    @NotBlank
    @Size(min = 4)
    String username;

    @NotBlank
    @Email
    @UniqueEmail
    String email;
    @NotBlank
    @Size(min = 4)
    String password;

    boolean active=false;

    String activationToken;

}
