package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "orderline_id")
    private UUID id;

    private int quantity;
    private UUID food_id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;



}
