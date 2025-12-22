package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
 
@RestController
public class AuthController {

    @Autowired
    UserService ser;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return ser.register(user);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity user) {
        return ser.findByEmail(user.getEmail());
    }
}
