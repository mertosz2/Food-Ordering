package com.example.orderservice.controller;

import com.example.orderservice.dto.LoginRequest;
import com.example.orderservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest){
        return authService.authenticate(loginRequest);
    }
}
