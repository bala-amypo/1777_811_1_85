package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity registerUser(UserEntity user);

    UserEntity findByEmail(String email);
}
