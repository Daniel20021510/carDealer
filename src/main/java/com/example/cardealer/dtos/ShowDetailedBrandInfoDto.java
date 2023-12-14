package com.example.cardealer.dtos;

import com.example.cardealer.models.enteties.Model;

import java.util.List;

public class ShowDetailedBrandInfoDto {

    private String name;

    private List<Model> models;

    public String getName() {
        return name;
    }

    public List<Model> getModels() {
        return models;
    }
}
