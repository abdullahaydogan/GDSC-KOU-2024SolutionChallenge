package com.example.demo.user;

import com.example.demo.shared.GenericMessage;
import com.example.demo.user.dto.UserCreate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/v1/users")
    GenericMessage userCreate(@Valid @RequestBody UserCreate user) {
        userService.userSave(user.toUser());
        return new GenericMessage("User is created");
    }

}
