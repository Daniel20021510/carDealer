package com.example.cardealer.dtos;

import com.example.cardealer.models.enteties.Model;
import com.example.cardealer.models.enteties.User;
import com.example.cardealer.models.enums.Category;
import com.example.cardealer.models.enums.Engine;
import com.example.cardealer.models.enums.Transmission;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddOfferDto {

    private String description;

    private Engine engine;

    private String imageUrl;

    private Integer mileage;

    private BigDecimal price;

    private Transmission transmission;

    private Integer offerYear;

    private String modelName;

    private String seller;

    public AddOfferDto() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getOfferYear() {
        return offerYear;
    }

    public void setOfferYear(Integer offerYear) {
        this.offerYear = offerYear;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
