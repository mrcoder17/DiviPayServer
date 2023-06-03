package ru.nsu.boxberger.DiviPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.boxberger.DiviPay.dto.AuthorizationRequest;
import ru.nsu.boxberger.DiviPay.exceptions.NotFoundException;
import ru.nsu.boxberger.DiviPay.service.AuthorizationService;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/api/login")
    public ResponseEntity<Long> login(@RequestBody AuthorizationRequest authorizationRequest) throws NotFoundException {
        authorizationService.login(authorizationRequest);
        Long userID = authorizationRequest.getUserID();
        return ResponseEntity.ok(userID);
    }

    @PostMapping("/api/registration")
    public ResponseEntity<Long> registration(@RequestBody AuthorizationRequest authorizationRequest) throws NotFoundException {
        authorizationService.registration(authorizationRequest);
        Long userID = authorizationRequest.getUserID();
        return ResponseEntity.ok(userID);
    }
}
