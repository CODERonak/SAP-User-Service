package com.microservice.SAPUserService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservice.SAPUserService.dto.*;
import com.microservice.SAPUserService.service.UsersService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

/*
 * This is the controller class for the users table in the database.
 * It has the folowing methods:
 * - registerUser: register a new user with the valid request
 * - getUserById: get a user by id
 */

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class UsersController {
    private final UsersService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest request) {
        UserResponse response = service.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
        UserResponse response = service.getUserById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}