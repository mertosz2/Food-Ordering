package com.example.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableKoyama {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "table_id")
    private UUID id;

    @Column(unique = true)
    private int table_number;

    private int capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "tableKoyama")
    private List<Users> usersList;
}
