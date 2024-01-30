package com.example.demo.auth.dto;

import com.example.demo.auth.token.Token;
import com.example.demo.user.dto.UserDTO;

public class AuthResponse {

    UserDTO userDTO;
    Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
