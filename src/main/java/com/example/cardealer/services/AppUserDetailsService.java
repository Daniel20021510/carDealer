package com.example.cardealer.services;

import com.example.cardealer.dtos.ShowBrandInfoDto;
import com.example.cardealer.dtos.ShowUserInfoDto;
import com.example.cardealer.models.enums.UserRole;
import com.example.cardealer.repositories.RoleRepository;
import com.example.cardealer.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(u -> new User(
                        u.getUsername(),
                        u.getUserPassword(),
                        u.getRoles().stream()
                                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRoleName().name()))
                                .toList()
                )).orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }

//    public List<ShowUserInfoDto> allSeller() {
//        return userRepository.findAllByRolesContains(roleRepository.findRoleByRoleName(UserRole.SELLER)).stream().map(seller -> mapper.map(seller, ShowUserInfoDto.class))
//                .collect(Collectors.toList());
//    }
}
