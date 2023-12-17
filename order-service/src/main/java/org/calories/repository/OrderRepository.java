package org.calories.repository;

import org.calories.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Order findById(Long id) {
        String query = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, this::mapToOrder);
    }


    public List<Order> findAll() {
        String query = "SELECT * FROM orders";
        return jdbcTemplate.query(query, this::mapToOrder);
    }



    public List<Order> findAllEmployeeOrders(Long employeeId) {
        String query = "SELECT * FROM orders WHERE employee_id = ?";
        return jdbcTemplate.query(query, new Object[]{employeeId}, this::mapToOrder);
    }


    public Order save(Order order) {
        String query = "INSERT INTO orders (last_updated, total_calories) VALUES (CURRENT_DATE, ?, ?)";
        jdbcTemplate.update(query, order.getTotalCalories());

        return order;
    }

    public Order update(Order order) {
        String query = "UPDATE orders SET last_updated = CURRENT_DATE, total_calories = ?, user_id = ? WHERE id = ?";
        jdbcTemplate.update(query, order.getTotalCalories(), order.getId());
       return order;
    }

    public void delete(Long id) {
        String query = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    private Order mapToOrder(ResultSet resultSet, int rowNum) throws SQLException {
        Long orderId = resultSet.getLong("id");
        Date lastUpdated = resultSet.getDate("last_updated");
        Integer totalCalories = resultSet.getInt("total_calories");
        return new Order(orderId, lastUpdated, totalCalories);
    }

    private List<Long> findDistinctProductIds(Long orderId) {
        String query = "SELECT DISTINCT product_id FROM product_order WHERE order_id = ?";
        return jdbcTemplate.queryForList(query, Long.class, orderId);
    }
}