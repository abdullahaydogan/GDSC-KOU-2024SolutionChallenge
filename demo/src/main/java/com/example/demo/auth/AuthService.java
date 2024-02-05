package com.example.demo.auth;

import com.example.demo.auth.dto.AuthResponse;
import com.example.demo.auth.dto.Credentials;
import com.example.demo.auth.exception.AuthenticationException;
import com.example.demo.auth.token.Token;
import com.example.demo.auth.token.TokenService;
import com.example.demo.user.User;
import com.example.demo.user.UserService;
import com.example.demo.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthResponse authenticate(Credentials credentials) {
        User inDB = userService.findByEmail(credentials.email());
        if (inDB == null) throw new AuthenticationException();
        if (!passwordEncoder.matches(credentials.password(), inDB.getPassword()))
            throw new AuthenticationException();
        Token token = tokenService.createToken(inDB, credentials);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setUserDTO(new UserDTO(inDB));
        return authResponse;
    }
}
