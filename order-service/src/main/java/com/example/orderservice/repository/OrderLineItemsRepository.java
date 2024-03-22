package com.example.orderservice.repository;

import com.example.orderservice.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, UUID> {
}
