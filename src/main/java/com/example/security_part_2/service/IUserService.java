package com.example.security_part_2.service;

import com.example.security_part_2.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User save(User user);
}
