package com.example.umc_spring_mission.repository.FoodCategoryRepository;

import com.example.umc_spring_mission.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<Food, Long> {
}
