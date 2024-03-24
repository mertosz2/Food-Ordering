package com.example.foodservice.repository;

import com.example.foodservice.dto.FoodResponse;
import com.example.foodservice.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByCategory(String category);

    @Query("SELECT f from Food f WHERE f.buffet_type=:buffet_Type")
    List<Food> findFoodByBuffetType(int buffet_Type);

    @Query("SELECT f from Food f WHERE f.id =:food_id")
    Optional<Food> findFoodByFoodId(UUID food_id);

}
