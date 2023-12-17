package org.calories.mapper;

import org.calories.dtos.EmployeeDto;
import org.calories.entity.Order;
import org.calories.dtos.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    public OrderDto mapToDto(EmployeeDto employeeDto, Order order) {

        return new OrderDto( order, employeeDto);

    }

    public List<OrderDto> mapToDto(EmployeeDto employeeDto, List<Order> order) {

        List<OrderDto> list = new ArrayList<>();
        order.forEach(orderItem -> {
            list.add(new OrderDto( orderItem, employeeDto));
        });
        return list;

    }
}
