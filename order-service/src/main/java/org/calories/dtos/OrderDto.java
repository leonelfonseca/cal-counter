package org.calories.dtos;

import org.calories.entity.Order;

import java.util.List;

public class OrderDto {
    EmployeeDto employeeDto;
    Order order;

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public Order getOrder() {
        return order;
    }

    public OrderDto(Order order, EmployeeDto employeeDto) {
        this.order = order;
        this.employeeDto = employeeDto;
    }
}
