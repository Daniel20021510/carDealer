package com.example.cardealer.repositories;

import com.example.cardealer.models.enteties.Role;
import com.example.cardealer.models.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<User> findByUsername(String username);

    Optional<List<User>> findAllByRolesContains(Optional<Role> role);
}
