package org.calories.controller;

import org.calories.dtos.EmployeeDto;
import org.calories.dtos.OrderDto;
import org.calories.entity.Order;
import org.calories.mapper.OrderMapper;
import org.calories.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Value("${service.employee.url}")
    private String employeeServiceUrl;


    private ObjectMapper objectMapper;
    private final RestTemplate restTemplate;


    private final OrderMapper orderMapper;

    private final OrderService orderService;

    @Autowired
    public OrderController(RestTemplate restTemplate, OrderMapper orderMapper, OrderService orderService) {
        this.restTemplate = restTemplate;
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping("/create/{employeeId}")
    public ResponseEntity<Void> createOrder(@PathVariable Long employeeId,  @RequestBody OrderDto orderDto) throws Exception {

        Order order = orderDto.getOrder();
        EmployeeDto employeeDto =  getEmployeeDto(employeeId);
        if(  employeeDto.getId() == null ){
            throw new Exception();
        }
        order.setEmployeeId(employeeDto.getId());
        this.orderService.createOrder(order);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @GetMapping("/employee/{employeeId}/orders")
    public ResponseEntity<List<OrderDto>> getAllOrdersByEmployeeId(@PathVariable Long employeeId) {
        List<OrderDto> orders=  getOrdersDto(employeeId);
        return ResponseEntity.ok(orders);
    }


    @GetMapping("/{employeeId}/{orderId}")
    public ResponseEntity<OrderDto> getEmployeeOrderByOrderId(@PathVariable Long employeeId, @PathVariable Long orderId) {

            OrderDto orderDto = getOrderDto(employeeId, orderId);
            return ResponseEntity.ok(orderDto);

    }

    public EmployeeDto getEmployeeDto(Long employeeId){
        String url = employeeServiceUrl + employeeId;
        return restTemplate.getForObject(url, EmployeeDto.class);

    }
    public OrderDto getOrderDto(Long employeeId, Long orderId){

        EmployeeDto employeeDto = getEmployeeDto(employeeId);
        Order order = orderService.findOrderById(orderId);
        return orderMapper.mapToDto(employeeDto, order);
    }

    public List<OrderDto> getOrdersDto(Long employeeId){
        EmployeeDto employeeDto = restTemplate.getForObject(this.employeeServiceUrl + employeeId, EmployeeDto.class);
        List<Order> orders= orderService.findOrdersById(employeeId);
        return orderMapper.mapToDto(employeeDto, orders);
    }
}