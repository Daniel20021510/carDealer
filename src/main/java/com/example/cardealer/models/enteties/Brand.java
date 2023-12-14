package com.example.cardealer.models.enteties;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Brand")
public class Brand extends BaseEntity{

    @Column(name = "name", nullable = false)
    public String name;

    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Model> models;

    protected Brand() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
