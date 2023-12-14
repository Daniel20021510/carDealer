package com.example.cardealer.repositories;

import com.example.cardealer.models.enteties.Role;
import com.example.cardealer.models.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findRoleByRoleName(UserRole role);
}
