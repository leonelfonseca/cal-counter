package org.calories.repository;

import org.calories.entity.Product;
import org.calories.entity.mapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Product findById(Long id) {
        String query = "SELECT * FROM food WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new ProductRowMapper());
    }

    public List<Product> findAll() {
        String query = "SELECT * FROM food";
        return jdbcTemplate.query(query, new ProductRowMapper());
    }

    public Product save(Product product) {
        String query = "INSERT INTO food (name, calories, type) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, product.getName(), product.getCalories(), product.getFoodType().name());
        return product;
    }

    public Product update(Product product) {
        String query = "UPDATE food SET name = ?, calories = ?, type = ? WHERE id = ?";
        jdbcTemplate.update(query, product.getName(), product.getCalories(), product.getFoodType().name(), product.getId());
        return product;
    }

    public void delete(Long id) {
        String query = "DELETE FROM food WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}