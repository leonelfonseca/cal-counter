package org.calories.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private Long id;
    @JsonProperty("username")
    private String username;

    public Employee(String username) {
        this.username = username;
    }

    public Employee(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
