package ru.nsu.boxberger.DiviPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.boxberger.DiviPay.dto.AuthorizationRequest;
import ru.nsu.boxberger.DiviPay.exceptions.NotFoundException;
import ru.nsu.boxberger.DiviPay.model.User;

@Service
public class AuthorizationService {

    @Autowired
    private UserService userService;
    public void login(AuthorizationRequest authorizationRequest) throws NotFoundException {
        String username = authorizationRequest.getUsername();
        String password = authorizationRequest.getPassword();

        if (!userService.existUserByUsernameAndPassword(username, password)) {
            throw new NotFoundException("User not found");
        }

        Long userID = userService.getUserIdByUsername(username);
        authorizationRequest.setUserID(userID);
    }

    public void registration(AuthorizationRequest authorizationRequest) throws NotFoundException {
        String newUsername = authorizationRequest.getUsername();
        String newPassword = authorizationRequest.getPassword();
        User newUser = new User(newUsername, newPassword);
        if (userService.createUser(newUser) == null) {
            throw new NotFoundException("User already created");
        }

        Long userId = userService.getUserIdByUsername(newUsername);
        authorizationRequest.setUserID(userId);
    }
}

