package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Food;
import com.example.umc_spring_mission.domain.UserFood;

import java.util.List;
import java.util.stream.Collectors;

public class UserFoodConverter {
    public static List<UserFood> toMemberPreferList(List<Food> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserFood.builder()
                                .food(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
