package org.calories.service;

import org.calories.model.entity.Employee;
import org.calories.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(String username) {
        Employee newEmployee = new Employee(username);
        return employeeRepository.save(newEmployee);
    }

    public Employee updateEmployee(Long userId, String newUsername) {
        Employee existingEmployee = employeeRepository.findById(userId);

        if (existingEmployee != null) {
            existingEmployee.setUsername(newUsername);
            return employeeRepository.save(existingEmployee);
        } else {

            return null;
        }
    }

    public void deleteById(Long id) {
        employeeRepository.delete(id);
    }
}