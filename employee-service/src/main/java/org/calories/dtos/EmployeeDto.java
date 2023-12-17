package org.calories.dtos;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {
    private Long id;
    private String username;

    public EmployeeDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public EmployeeDto() {
    }

    @JsonCreator
    public EmployeeDto(@JsonProperty("username") String username) {
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

