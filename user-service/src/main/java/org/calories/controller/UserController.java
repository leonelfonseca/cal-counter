package org.calories.controller;


import org.calories.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.calories.model.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    // Guarantes that Service is created if controller is created
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody String username) {
        return userService.createNewUser(username);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody String username) {
        return userService.updateUser(id, username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}