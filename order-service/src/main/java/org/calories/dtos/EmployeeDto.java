package org.calories.dtos;


public class EmployeeDto {
    public EmployeeDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    private Long id;
    private  String username;

    public String getUsername() {
        return username;
    }
}
