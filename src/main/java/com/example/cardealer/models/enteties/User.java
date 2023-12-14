package com.example.cardealer.models.enteties;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User extends BaseEntity implements Serializable {

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private List<Role> roles;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Offer> offers = new HashSet<Offer>();

    public User() {}

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

