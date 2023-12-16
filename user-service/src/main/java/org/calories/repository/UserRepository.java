package org.calories.repository;

import org.calories.model.entity.User;
import org.calories.model.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findById(Long id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new UserRowMapper());
    }

    public List<User> findAll() {
        String query = "SELECT * FROM users";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    public User save(User user) {
        String query = "INSERT INTO users (username) VALUES (?)";
        jdbcTemplate.update(query,user.getUsername());
        return user;
    }

    public User update(User user) {
        String query = "UPDATE users SET username = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getUsername());
        return user;
    }

    public void delete(Long id) {
        String query = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
