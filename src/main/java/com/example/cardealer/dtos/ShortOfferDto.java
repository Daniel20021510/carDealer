package com.example.cardealer.dtos;

import com.example.cardealer.models.enums.Engine;
import com.example.cardealer.models.enums.Transmission;

import java.math.BigDecimal;

public class ShortOfferDto {

    private Engine engine;

    private String imageUrl;

    private Integer mileage;

    private BigDecimal price;

    private Transmission transmission;

    private Integer offerYear;

    private String modelName;

    private String brandName;

    public ShortOfferDto() {
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
