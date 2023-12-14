package com.example.cardealer.models.enteties;

import com.example.cardealer.models.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true)
    private UserRole roleName;

//    @ManyToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<User> users = new HashSet<User>();

    public Role() {}

    public UserRole getRoleName() {
        return roleName;
    }

    public void setRoleName(UserRole roleName) {
        this.roleName = roleName;
    }
}

