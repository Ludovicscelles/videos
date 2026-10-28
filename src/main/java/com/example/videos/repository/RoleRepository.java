package com.example.videos.repository;

import com.example.videos.entity.Role;
import com.example.videos.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(RoleEnum role);
}
