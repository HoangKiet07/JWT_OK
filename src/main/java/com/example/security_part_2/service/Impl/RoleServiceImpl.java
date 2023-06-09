package com.example.security_part_2.service.Impl;

import com.example.security_part_2.model.Role;
import com.example.security_part_2.model.RoleName;
import com.example.security_part_2.repository.IRoleRepository;
import com.example.security_part_2.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
