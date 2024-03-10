package com.example.foodservice.service;

import com.example.foodservice.dto.FoodRequest;
import com.example.foodservice.model.Food;
import com.example.foodservice.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    public ResponseEntity<String> createFood(FoodRequest request){
        Food food = new Food();
        food.setName(request.getName());
        food.setCategory(request.getCategory());
        food.setImg_url(request.getImg_url());
        foodRepository.save(food);
        return ResponseEntity.status(201).body("food created !");
    }


}
