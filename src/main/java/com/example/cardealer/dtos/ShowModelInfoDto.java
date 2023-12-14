package com.example.cardealer.dtos;

public class ShowModelInfoDto {

    private String name;

    public ShowModelInfoDto() {}

    public ShowModelInfoDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
