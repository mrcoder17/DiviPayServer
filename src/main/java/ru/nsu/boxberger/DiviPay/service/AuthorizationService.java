package ru.nsu.boxberger.DiviPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.boxberger.DiviPay.exceptions.NotFoundException;
import ru.nsu.boxberger.DiviPay.model.User;

@Service
public class AuthorizationService {
    private static final String DEFAULT_IMG_URL = "https://i.postimg.cc/8P3wGrYx/avatar.jpg";

    @Autowired
    private UserService userService;

    public void login(User user) throws NotFoundException {
        if (!userService.existUserByUsernameAndPassword(user.getUsername(), user.getPassword())) {
            throw new NotFoundException("User not found");
        }
    }

    public void registration(User user) throws NotFoundException {
        User newUser = new User(user.getUsername(), user.getPassword());
        if (userService.createUser(newUser) == null) {
            throw new NotFoundException("User already created");
        }
        newUser.setAvatar(DEFAULT_IMG_URL);
    }
}

