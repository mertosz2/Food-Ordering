package com.example.orderservice.controller;

import com.example.orderservice.dto.TableRequest;
import com.example.orderservice.service.TableKoyamaService;
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
