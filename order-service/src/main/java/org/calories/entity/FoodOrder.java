package org.calories.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food_order")
public class FoodOrder {

    public Long getId() {
        return id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

}