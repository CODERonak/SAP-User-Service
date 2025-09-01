package com.microservice.SAPUserService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.microservice.SAPUserService.dto.UserRequest;
import com.microservice.SAPUserService.dto.UserResponse;
import com.microservice.SAPUserService.model.Users;

/*
 * This is the mapper interface for the users table in the database.
 * It has the folowing methods:
 * - toModel: map the user request objects to the user model objects
 * - toResponse: map the user model objects to the user response objects
 */

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(target = "userId", ignore = true)
    Users toModel(UserRequest userRequest);

    UserResponse toResponse(Users users);
}