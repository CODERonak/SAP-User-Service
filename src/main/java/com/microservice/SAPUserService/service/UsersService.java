package com.microservice.SAPUserService.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.SAPUserService.UsersRepository;
import com.microservice.SAPUserService.dto.*;
import com.microservice.SAPUserService.mapper.UsersMapper;
import com.microservice.SAPUserService.model.Users;

import lombok.AllArgsConstructor;

/*
 * This is the service class for the users table in the database.
 * It has the folowing methods:
 * - registerUser: register a new user with hashed password 
 * - getUserById: get a user by id
 */

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository repository;
    private final UsersMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponse registerUser(UserRequest request) {
        if (repository.existsByEmail(request.getEmail()))
            throw new IllegalArgumentException(
                    "Email already exists, if you want create a new account please use a different email");

        Users user = mapper.toModel(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Users saved = repository.save(user);
        return mapper.toResponse(saved);
    }

    public UserResponse getUserById(Long userId) {
        Users user = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return mapper.toResponse(user);
    }
}