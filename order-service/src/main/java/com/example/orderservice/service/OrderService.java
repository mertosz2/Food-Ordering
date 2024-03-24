package com.example.orderservice.service;

import com.example.orderservice.dto.*;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.model.Users;
import com.example.orderservice.repository.OrderLineItemsRepository;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final UsersRepository usersRepository;
    private final OrderRepository orderRepository;
    private final OrderLineItemsRepository orderLineItemsRepository;
    private final WebClient.Builder webClientBuilder;

    public ResponseEntity<String> placeOrder(String username, OrderRequest request) {
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

        return ResponseEntity.status(201).body("place order successfully");
    }

    public List<OrderInfo> findAllOrderFromUser(String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow();
        List<Order> orderList = orderRepository.findAllOrderByUser(users.getId()).orElseThrow();
        List<UUID> orderIdList = orderList.stream().map(Order::getId).toList();
        List<OrderInfo> orderInfoList = new ArrayList<>();

        for (UUID orderId : orderIdList) {
            FoodRequest foodRequest = new FoodRequest();
            foodRequest.setFoodIdRequestList(mapToDto(orderId));


            List<FoodResponse> foodResponseList = webClientBuilder.build().post()
                    .uri("http://food-service/food/foodId")
                    .bodyValue(foodRequest)
                    .retrieve()
                    .bodyToMono(List.class)
                    .block();

            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrder_id(orderId);
            orderInfo.setFoodResponseList(foodResponseList);
            orderInfoList.add(orderInfo);
        }

        return orderInfoList;
    }


    public List<FoodIdRequest> mapToDto(UUID order_id) {
        List<OrderLineItems> orderLineItems = orderLineItemsRepository.findOrderLineItemsByOrderId(order_id).orElseThrow();
        List<FoodIdRequest> foodIdRequest = orderLineItems.stream()
                .map(orderLineItem -> FoodIdRequest.builder()
                        .food_id(orderLineItem.getFood_id())
                        .build())
                .toList();
        return foodIdRequest;
    }



    public OrderLineItems mapToOrderLineItems(Order order, OrderLineItemDto orderLineItemDto) {
        OrderLineItems orderLineItems = OrderLineItems.builder()
                .id(UUID.randomUUID())
                .food_id(orderLineItemDto.getId())
                .quantity(orderLineItemDto.getQuantity())
                .order(order)
                .build();
        return orderLineItems;
    }
}
