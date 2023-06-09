package com.example.security_part_2.service;

import com.example.security_part_2.model.Role;
import com.example.security_part_2.model.RoleName;

import java.util.Optional;

public interface IRoleService {

    Optional<Role> findByName(RoleName name);
}
