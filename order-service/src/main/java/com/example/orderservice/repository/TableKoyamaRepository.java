package com.example.orderservice.repository;

import com.example.orderservice.model.TableKoyama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TableKoyamaRepository extends JpaRepository<TableKoyama, UUID> {

    @Query("select tb from TableKoyama tb where tb.table_number =:table_number")
    TableKoyama findTableKoyamaByTableNumber(int table_number);
}
