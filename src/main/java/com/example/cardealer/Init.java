package com.example.cardealer;

import com.example.cardealer.models.enteties.Role;
import com.example.cardealer.models.enteties.User;
import com.example.cardealer.models.enums.UserRole;
import com.example.cardealer.repositories.RoleRepository;
import com.example.cardealer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPassword;

    public Init(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, @Value("${app.default.password}") String defaultPassword) {
        this.roleRepository = roleRepository;
        this. userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if (roleRepository.count() == 0) {
            var moderatorRole = new Role();
            moderatorRole.setRoleName(UserRole.MODERATOR);
            var adminRole = new Role();
            adminRole.setRoleName(UserRole.ADMIN);
            var normalUserRole = new Role();
            normalUserRole .setRoleName(UserRole.USER);
            roleRepository.save(moderatorRole);
            roleRepository.save(adminRole);
            roleRepository.save(normalUserRole);
        }
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
//            initModerator();
//            initNormalUser();
        }
    }

    private void initAdmin(){
       var adminRole = roleRepository.
                findRoleByRoleName(UserRole.ADMIN).orElseThrow();

       var adminUser = new User();
       adminUser.setRoles(List.of(adminRole));
       adminUser.setUsername("admin");
       adminUser.setLastName("admin");
       adminUser.setFirstName("admin");
       adminUser.setActive(true);
       adminUser.setUserPassword(passwordEncoder.encode(defaultPassword));

       userRepository.save(adminUser);
    }

//    private void initModerator(){
//
//        var moderatorRole = userRoleRepository.
//                findRoleByName(UserRoles.MODERATOR).orElseThrow();
//
//        var moderatorUser = new User("moderator", passwordEncoder.encode(defaultPassword), "moderator@example.com", "Moder Moderovich", 24);
//        moderatorUser.setRoles(List.of(moderatorRole));
//
//        userRepository.save(moderatorUser);
//    }
//
//    private void initNormalUser(){
//        var userRole = userRoleRepository.
//                findRoleByName(UserRoles.USER).orElseThrow();
//
//        var normalUser = new User("user", passwordEncoder.encode(defaultPassword), "user@example.com", "User Userovich", 22);
//        normalUser.setRoles(List.of(userRole));
//
//        userRepository.save(normalUser);
//    }
}
