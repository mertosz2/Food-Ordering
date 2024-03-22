package com.example.orderservice.repository;

import com.example.orderservice.model.TableKoyama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TableKoyamaRepository extends JpaRepository<TableKoyama, UUID> {


}
