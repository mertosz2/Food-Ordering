package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String test(){
        return "test";
    }

    @GetMapping("/placeOrder")
    public String testP(){
        return "authenticated";
    }
}
