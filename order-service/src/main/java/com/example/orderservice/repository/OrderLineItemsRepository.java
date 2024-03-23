package com.example.orderservice.repository;

import com.example.orderservice.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, UUID> {

    @Query("select ol from OrderLineItems ol where ol.order.id =:order_id")
    Optional<List<OrderLineItems>> findOrderLineItemsByOrderId(UUID order_id);
}
