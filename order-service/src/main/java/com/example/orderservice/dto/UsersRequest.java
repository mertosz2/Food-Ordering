package com.example.orderservice.dto;

import lombok.Data;

@Data
public class UsersRequest {

    private int num_of_people;
    private int buffet_type;
    private int table_number;
}
