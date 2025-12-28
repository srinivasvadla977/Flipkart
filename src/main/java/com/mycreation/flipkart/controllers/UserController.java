package com.mycreation.flipkart.controllers;

import com.mycreation.flipkart.models.User;
import com.mycreation.flipkart.models.UserAuthReq;
import com.mycreation.flipkart.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @Operation(summary = "=> Enables new Users to register")
    public ResponseEntity<Object> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    @Operation(summary = "=> Returns token once a valid user logs in ")
    public ResponseEntity<Object> loginUser(@RequestBody UserAuthReq userAuthReq){
        return userService.loginUser(userAuthReq);
    }

}
