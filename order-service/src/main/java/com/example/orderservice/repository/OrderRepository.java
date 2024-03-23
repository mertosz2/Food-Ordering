package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o from Order o WHERE o.users.id =:users_id")
    Optional<List<Order>> findAllOrderByUser(UUID users_id);
}
