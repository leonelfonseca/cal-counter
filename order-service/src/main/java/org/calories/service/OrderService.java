package org.calories.service;

import org.calories.entity.Order;
import org.calories.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id);
    }
    public List<Order> findOrdersById(Long id) {
        return orderRepository.findAllEmployeeOrders(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, Order order) {
        Order existingOrder = orderRepository.findById(orderId);

        if (existingOrder != null) {
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }


    public void deleteById(Long id) {
        orderRepository.delete(id);
    }
}