package com.example.foodservice.service;

import com.example.foodservice.dto.FoodRequest;
import com.example.foodservice.dto.FoodResponse;
import com.example.foodservice.model.Food;
import com.example.foodservice.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    public ResponseEntity<String> createFood(FoodRequest request){
        Food food = new Food();
        food.setName(request.getName());
        food.setCategory(request.getCategory());
        food.setImg_url(request.getImg_url());
        food.setBuffet_type(request.getBuffet_Type());
        foodRepository.save(food);
        return ResponseEntity.status(201).body("food created !");
    }

    public ResponseEntity<List<FoodResponse>> getAllFood(){
        List<FoodResponse> foodResponseList = foodRepository.findAll()
                .stream().map(this::maptoFoodResponse
                ).toList();
        return ResponseEntity.status(200).body(foodResponseList);
    }


    public ResponseEntity<List<FoodResponse>> findByCategory(String category){
        List<FoodResponse> foodResponseList = foodRepository.findByCategory(category).stream()
                .map(this::maptoFoodResponse
                ).toList();
        return ResponseEntity.status(200).body(foodResponseList);


    }

    public ResponseEntity<List<FoodResponse>> getAllFoodByBuffetType(int buffet_Type){
        List<FoodResponse> foodResponseList = foodRepository.findFoodByBuffetType(buffet_Type)
                .stream().map(this::maptoFoodResponse
                        ).toList();
        return ResponseEntity.status(200).body(foodResponseList);
    }

    public FoodResponse maptoFoodResponse(Food food){
        return FoodResponse.builder()
                .id(food.getId())
                .name(food.getName())
                .category(food.getCategory())
                .img_url(food.getImg_url())
                .build();
    }
}
