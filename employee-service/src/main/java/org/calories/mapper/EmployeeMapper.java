package org.calories.mapper;

import org.calories.dtos.EmployeeDto;
import org.calories.model.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto mapToDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getUsername());
    }

    public EmployeeMapper() {
    }
}
