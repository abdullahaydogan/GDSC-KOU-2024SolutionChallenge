package com.example.demo.user;

import com.example.demo.auth.token.TokenService;
import com.example.demo.configuration.CurrentUser;
import com.example.demo.user.dto.UserCreate;
import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.dto.UserUpdate;
import com.example.demo.user.exception.AuthorizationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
    Page<UserDTO> getUsers(Pageable pageable, @AuthenticationPrincipal CurrentUser currentUser) {
        return userService.getUsers(pageable, currentUser).map(UserDTO::new);
    }

    //list by id number
    @GetMapping("/userListById/{id}")
    UserDTO getUserById(@PathVariable int id) {
        return new UserDTO(userService.getUserById(id));
    }

    @PatchMapping("/userActivation/{token}/active")
    ResponseEntity<String> activateUser(@PathVariable String token) {
        userService.activateUser(token);
        return ResponseEntity.ok("User is activated..");
    }


    //User Update
    @PutMapping("/userUpdate/{id}")
    UserDTO updateUser(@PathVariable int id, @Valid @RequestBody UserUpdate userUpdate,@AuthenticationPrincipal CurrentUser currentUser ) {
        if (currentUser.getId() != id ){
            throw new AuthorizationException();
        }
        return new UserDTO(userService.updateUser(id, userUpdate));
    }


}
