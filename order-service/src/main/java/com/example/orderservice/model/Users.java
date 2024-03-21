package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "users_id")
    private UUID id;

    private String username;
    private String password;
    private int num_of_people;
    private int buffet_type;

    @OneToMany(mappedBy = "users")
    private List<Order> orderList;
}
