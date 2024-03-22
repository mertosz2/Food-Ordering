package com.example.orderservice.service;

import com.example.orderservice.dto.OrderLineItemDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.model.Users;
import com.example.orderservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UsersRepository usersRepository;

    public ResponseEntity<String> placeOrder(String username, OrderRequest request){
        Users users = usersRepository.findByUsername(username).orElseThrow();
        Order order = new Order();
        LocalDateTime dateTime = LocalDateTime.now().withSecond(0);


        return  ResponseEntity.status(201).body("");
    }

    public OrderLineItems mapToOrderLineItems(Order order, OrderLineItemDto orderLineItemDto){
        OrderLineItems orderLineItems = OrderLineItems.builder()
                .id(UUID.randomUUID())
                .food_id(orderLineItemDto.getId())
                .quantity(orderLineItemDto.getQuantity())
                .order(order)
                .build();
        return orderLineItems;
    }
}
