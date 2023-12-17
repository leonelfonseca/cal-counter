package org.calories.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.calories.dtos.EmployeeDto;
import org.calories.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.calories.model.entity.Employee;
import org.calories.mapper.EmployeeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final ObjectMapper objectMapper;
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    // Guarantes that Service is created if controller is created
    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDTO = employeeMapper.mapToDto(employee);
        return ResponseEntity.ok(employeeDTO);
    }

    @PostMapping("/create")
    public Employee create(@RequestBody String username) throws JsonProcessingException {
        EmployeeDto employeeDto = objectMapper.readValue(username, EmployeeDto.class);
        return employeeService.createEmployee(employeeDto.getUsername());
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody String username) {
        return employeeService.updateEmployee(id, username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}