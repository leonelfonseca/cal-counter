
package org.calories.model.entity;

import jakarta.persistence.*;


public class User {
    public User(String username) {
        this.username = username;
    }

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;



}
