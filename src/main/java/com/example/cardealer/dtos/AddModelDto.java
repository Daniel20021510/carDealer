package com.example.cardealer.dtos;

import com.example.cardealer.models.enums.Category;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AddModelDto {

    private String name;

    private Category category;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;

    private String brandName;

    public AddModelDto() {}

    @NotEmpty(message = "Model name must not be null or empty!")
    @Size(min = 2, max = 40, message = "Model name must be between 2 and 40 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @MatchCategory(anyOf = {Category.Car, Category.Buss, Category.Truck, Category.Motorcycle})
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @NotEmpty(message = "Model image URL must not be null or empty!")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //TODO: Make custom year validation that year not greater than now
    @Digits(integer = 4, fraction = 0, message = "Model start year must contain 4 digits!")
    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    //TODO: Make custom year validation that year not lower than start year
    @Digits(integer = 4, fraction = 0, message = "Model start year must contain 4 digits!")
    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
