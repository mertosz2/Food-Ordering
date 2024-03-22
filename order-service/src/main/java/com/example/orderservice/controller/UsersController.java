package com.example.orderservice.controller;

import com.example.orderservice.dto.UsersRequest;
import com.example.orderservice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    @PostMapping
    public String createTable(@RequestBody UsersRequest request){
        return usersService.createUser(request);
    }
}
