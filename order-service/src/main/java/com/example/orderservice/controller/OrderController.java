package com.example.orderservice.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
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
