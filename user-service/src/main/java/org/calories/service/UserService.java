package org.calories.service;

import org.calories.model.entity.User;
import org.calories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User createNewUser(String username) {
        User newUser = new User(username);
        return userRepository.save(newUser);
    }

    public User updateUser(Long userId, String newUsername) {
        User existingUser = userRepository.findById(userId);

        if (existingUser != null) {
            existingUser.setUsername(newUsername);
            return userRepository.save(existingUser);
        } else {

            return null;
        }
    }

    public void deleteById(Long id) {
        userRepository.delete(id);
    }
}