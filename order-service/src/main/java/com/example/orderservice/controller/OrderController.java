package com.example.orderservice.controller;
import com.example.orderservice.dto.*;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest request){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return orderService.placeOrder(username, request);
    }

    @GetMapping("/orderList")
    public List<OrderInfo> findAll(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return orderService.findAllOrderFromUser(username);
    }


}
