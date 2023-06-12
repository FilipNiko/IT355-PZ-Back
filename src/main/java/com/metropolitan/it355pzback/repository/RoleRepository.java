package com.metropolitan.it355pzback.repository;

import com.metropolitan.it355pzback.data.entities.Role;
import com.metropolitan.it355pzback.data.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleType name);



}