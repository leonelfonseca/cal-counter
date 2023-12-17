package org.calories.entity;



import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Order {

    private Long id;

    private Date lastUpdated;
    private Integer totalCalories;

    public Order(Long id, Date lastUpdated, Integer totalCalories) {
        this.id = id;

        this.lastUpdated = lastUpdated;
        this.totalCalories = totalCalories;

    }


    public Order() {
    }



    public Long getId() {
        return id;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

}
