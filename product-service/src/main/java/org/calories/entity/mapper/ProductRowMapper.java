package org.calories.entity.mapper;

import org.calories.entity.Product;
import org.calories.enums.FoodType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Product product = new Product(resultSet.getString("name"), resultSet.getString("calories"), FoodType.valueOf(resultSet.getString("type")));
        return product;
    }
}