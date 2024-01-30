package com.example.demo.auth.token;

import com.example.demo.auth.dto.Credentials;
import com.example.demo.user.User;

public interface TokenService {

    Token createToken(User user, Credentials credentials);

    User verifyToken(String authorizationHeader);
}
