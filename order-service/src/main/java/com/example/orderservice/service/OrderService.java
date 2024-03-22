package com.example.orderservice.service;

import com.example.orderservice.dto.OrderLineItemDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.model.Users;
import com.example.orderservice.repository.OrderLineItemsRepository;
import com.example.orderservice.repository.OrderRepository;
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
    private final OrderRepository orderRepository;
    private final OrderLineItemsRepository orderLineItemsRepository;

    public ResponseEntity<String> placeOrder(String username, OrderRequest request){
        Users users = usersRepository.findByUsername(username).orElseThrow();
        Order order = new Order();
        LocalDateTime dateTime = LocalDateTime.now().withSecond(0);
        List<OrderLineItems> orderLineItemsList = request.getOrderLineItemDtoList().stream()
                .map(orderLineItemDto -> mapToOrderLineItems(order, orderLineItemDto)).toList();

        order.setDateTime(dateTime);
        order.setUsers(users);
        order.setOrderLineItemsList(orderLineItemsList);
        orderRepository.save(order);
        orderLineItemsRepository.saveAll(orderLineItemsList);

        return  ResponseEntity.status(201).body("place order successfully");
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
