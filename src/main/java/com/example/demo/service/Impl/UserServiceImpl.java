package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
 
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserEntity register(UserEntity user) {
        return repo.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}
