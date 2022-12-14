package com.example.musicbackend.repository.user;

import com.example.musicbackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findByName(String role);
}
