package com.example.demo.auth.token;

import com.example.demo.auth.dto.Credentials;
import com.example.demo.user.User;
import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class BasicAuthTokenService implements TokenService {
    @Autowired
    UserService userService;

    @Override
    public Token createToken(User user, Credentials credentials) {
        String emailColonPassword = credentials.email() + ":" + credentials.password();
        String token = Base64.getEncoder().encodeToString(emailColonPassword.getBytes());
        return new Token("Basic", token);
    }

    @Override
    public User verifyToken(String authorizationHeader) {
        if (authorizationHeader == null) return null;
        var base64Encoded = authorizationHeader.split("Basic")[1];
        var decoded = new String(Base64.getDecoder().decode(base64Encoded));
        var credentials = decoded.split(":");
        var email = credentials[0];
        var userPassword = credentials[1];
        User inDB = userService.findByEmail(email);
        if (inDB == null) return null;
        if (inDB.getPassword() != userPassword) return null;
        return inDB;
    }
}
