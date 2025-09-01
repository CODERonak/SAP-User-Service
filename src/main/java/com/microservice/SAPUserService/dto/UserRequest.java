package com.microservice.SAPUserService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*
 * This is the DTO class for the users table in the database.
 * It has the folowing fields:
 * - fullname: the full name of the user should not be blank
 * - email: the email of the user which will be unique and valid
 * - password: the password of the user which will be hashed and at least 8 characters long
 * - bio: the bio of the user which will be optional
 */

@Data
public class UserRequest {
    @NotBlank
    private String fullname;

    @Email
    private String email;

    @Size(min = 8)
    private String password;

    private String bio;
}