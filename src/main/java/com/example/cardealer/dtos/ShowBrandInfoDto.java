package com.example.cardealer.dtos;

public class ShowBrandInfoDto {

    private String name;

    public ShowBrandInfoDto() {}

    public ShowBrandInfoDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
