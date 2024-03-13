package com.example.foodservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodRequest {

    private String name;
    private String category;
    private String img_url;
    private int buffet_Type;
}
