
package org.calories.entity;

import jakarta.persistence.*;
import org.calories.enums.FoodType;

public class Product {

    private Long id;
    private String name;

    public Product(String name, String calories, FoodType foodType) {
        this.name = name;
        this.calories = calories;
        this.foodType = foodType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    private String calories;
    private FoodType foodType;

}
