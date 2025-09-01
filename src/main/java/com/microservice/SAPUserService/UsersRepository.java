package com.microservice.SAPUserService;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.SAPUserService.model.Users;

/*
 * This is the repository interface for the users table in the database.
 * It has the folowing methods:
 * - findByEmail: find a user by email
 * - existsByEmail: check if a user exists by email
 */

public interface UsersRepository extends JpaRepository<Users, Long> {
    // Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);
}