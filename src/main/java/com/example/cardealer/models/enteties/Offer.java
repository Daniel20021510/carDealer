package com.example.cardealer.models.enteties;

import com.example.cardealer.models.enums.Engine;
import com.example.cardealer.models.enums.Transmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Offers")
public class Offer extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "engine", nullable = false)
    private Engine engine;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission", nullable = false)
    private Transmission transmission;

    @Column(name = "offer_year", nullable = false)
    private Integer offerYear;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    protected Offer() {
    }

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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}

