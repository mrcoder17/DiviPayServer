package ru.nsu.boxberger.DiviPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nsu.boxberger.DiviPay.model.User;
import ru.nsu.boxberger.DiviPay.service.UserService;

import java.util.ArrayList;
import java.util.List;

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

//    @GetMapping("/{id}")
//    public User getUserByID(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        return userService.updateUser(username, user);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }
}

