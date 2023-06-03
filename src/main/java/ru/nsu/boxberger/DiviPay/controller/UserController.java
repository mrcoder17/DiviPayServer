package ru.nsu.boxberger.DiviPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.boxberger.DiviPay.model.User;
import ru.nsu.boxberger.DiviPay.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<String> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<String> usernames = new ArrayList<>();

        for (User user : users){
            if (user.getName() == null){
                usernames.add(user.getUsername());
            } else {
                usernames.add(user.getName());
            }
        }
        return usernames;
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        return userService.updateUser(id, updateUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

