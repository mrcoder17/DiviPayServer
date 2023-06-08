package ru.nsu.boxberger.DiviPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.boxberger.DiviPay.exceptions.NotFoundException;
import ru.nsu.boxberger.DiviPay.model.User;
import ru.nsu.boxberger.DiviPay.repository.UserRepository;

@Service
public class AuthorizationService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public User login(User user) throws NotFoundException {
        if (!userService.existUserByUsernameAndPassword(user.getUsername(), user.getPassword())) {
            throw new NotFoundException("User not found");
        }
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public User registration(User user) throws NotFoundException {
        User newUser = new User(user.getUsername(), user.getPassword());
        if (userService.createUser(newUser) == null) {
            throw new NotFoundException("User already created");
        } else {
            return userRepository.findByUsernameAndPassword(newUser.getUsername(), newUser.getPassword());
        }
    }
}

