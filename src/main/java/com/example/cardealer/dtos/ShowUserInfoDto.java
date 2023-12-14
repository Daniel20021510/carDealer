package com.example.cardealer.dtos;

import jakarta.persistence.Column;

public class ShowUserInfoDto {

    private String firstName;

    private String lastName;

    public ShowUserInfoDto() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
