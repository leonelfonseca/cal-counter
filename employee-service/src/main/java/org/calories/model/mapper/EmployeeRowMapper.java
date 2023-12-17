package org.calories.model.mapper;


import org.calories.model.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee(resultSet.getLong ("id"), resultSet.getString("username"));
        return employee;
    }
}
