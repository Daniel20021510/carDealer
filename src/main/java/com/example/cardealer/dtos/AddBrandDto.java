package com.example.cardealer.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AddBrandDto {

    private String name;

    public AddBrandDto() {}

    public AddBrandDto(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Brand name must not be null or empty!")
    @Size(min = 2, max = 40, message = "Brand name must be between 2 and 40 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
