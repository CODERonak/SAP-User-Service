package com.microservice.SAPUserService.dto;

import lombok.Data;

/*
 * This is the DTO class for the users table in the database.
 * It has the folowing fields:
 * These fields are for the response of the registered user
 * - userId: the id of the user
 * - fullname: the full name of the user
 * - email: the email of the user
 * - bio: the bio of the user
 */

@Data
public class UserResponse {
    private Long userId;

    private String fullname;

    private String email;

    private String bio;
}