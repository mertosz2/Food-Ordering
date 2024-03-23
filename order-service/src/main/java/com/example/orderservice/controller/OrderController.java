package com.example.orderservice.controller;
import com.example.orderservice.dto.FoodResponse;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
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

    @GetMapping
    public List<FoodResponse> findAll(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return orderService.findAllOrderFromUserId(username);
    }

}
