package com.example.cardealer.services;

import com.example.cardealer.dtos.UserRegistrationDto;
import com.example.cardealer.models.enteties.User;
import com.example.cardealer.models.enums.UserRole;
import com.example.cardealer.repositories.RoleRepository;
import com.example.cardealer.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;


    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void register(UserRegistrationDto registrationDTO) {
        if (!registrationDTO.getUserPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());

        if (byUsername.isPresent()) {
            throw new RuntimeException("username.used");
        }

        var userRole = roleRepository.
                findRoleByRoleName(UserRole.USER).orElseThrow();

        User user = new User();

        user.setActive(true);
        user.setUsername(registrationDTO.getUsername());
        user.setUserPassword(passwordEncoder.encode(registrationDTO.getUserPassword()));
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setImageUrl(registrationDTO.getImageUrl());


        user.setRoles(List.of(userRole));

        this.userRepository.save(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}