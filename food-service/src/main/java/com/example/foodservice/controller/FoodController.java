package com.example.foodservice.controller;

import com.example.foodservice.dto.FoodRequest;
import com.example.foodservice.dto.FoodResponse;
import com.example.foodservice.model.Food;
import com.example.foodservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<String> createFood(@RequestBody FoodRequest request){
        return foodService.createFood(request);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<FoodResponse>> findFoodByCategory(@PathVariable String category){
        return foodService.findByCategory(category);
    }

    @GetMapping("/buffet/{buffet_Type}")
    public ResponseEntity<List<FoodResponse>> findFoodByBuffetType(@PathVariable int buffet_Type){
        return foodService.getAllFoodByBuffetType(buffet_Type);
    }

    @GetMapping("/AllMenu")
    public ResponseEntity<List<FoodResponse>> getAllMenu(){
        return foodService.getAllFood();
    }


}
