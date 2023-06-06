package ru.nsu.boxberger.DiviPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.boxberger.DiviPay.exceptions.NotFoundException;
import ru.nsu.boxberger.DiviPay.model.User;
import ru.nsu.boxberger.DiviPay.service.AuthorizationService;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/api/login")
    public ResponseEntity<User> login(@RequestBody User user) throws NotFoundException {
        authorizationService.login(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/registration")
    public ResponseEntity<User> registration(@RequestBody User user) throws NotFoundException {
        authorizationService.registration(user);
        return ResponseEntity.ok(user);
    }
}
