package com.example.demo.user;

import com.example.demo.auth.token.TokenService;
import com.example.demo.user.dto.UserCreate;
import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.dto.UserUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //user create
    @PostMapping("/userCreate")
    public ResponseEntity<String> userCreate(@Valid @RequestBody UserCreate user) {
        userService.userSave(user.toUser());
        return ResponseEntity.ok("User is created");
    }
    //list all of users
    @GetMapping("/userList")
    List<User> getUsers() {
        return userService.getUsers();
    }
    //list by id number
    @GetMapping("/userListById/{id}")
    UserDTO getUserById(@PathVariable int id) {
        return new UserDTO(userService.getUserById(id)); 
    }

    //User Update
    @PutMapping("/userUpdate/{id}")
    UserDTO updateLongitude(@PathVariable int id, @RequestBody UserUpdate userUpdate) {
        return new UserDTO(userService.updateUser(id, userUpdate));
    }




}
