package org.calories.repository;

import org.calories.model.entity.Employee;
import org.calories.model.mapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee findById(Long id) {
        List<Employee> employees =  jdbcTemplate.query("SELECT * FROM employee WHERE id = ?", new EmployeeRowMapper(), id);
        if(employees != null && employees.size() == 1){
            return employees.get(0);
        }
        return null;

    }

    public List<Employee> findAll() {
        String query = "SELECT * FROM employee";
        return jdbcTemplate.query(query, new EmployeeRowMapper());
    }

    public Employee save(Employee employee) {
        String query = "INSERT INTO employee (username) VALUES (?)";
        jdbcTemplate.update(query, employee.getUsername());
        return employee;
    }

    public Employee update(Employee employee) {
        String query = "UPDATE employee SET username = ? WHERE id = ?";
        jdbcTemplate.update(query, employee.getUsername());
        return employee;
    }

    public void delete(Long id) {
        String query = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
