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
    public ResponseEntity<Void> login(@RequestBody AuthorizationRequest authorizationRequest) throws NotFoundException {
        authorizationService.login(authorizationRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/registration")
    public ResponseEntity<Void> registration(@RequestBody AuthorizationRequest authorizationRequest) throws NotFoundException {
        authorizationService.registration(authorizationRequest);
        return ResponseEntity.ok().build();
    }
}
