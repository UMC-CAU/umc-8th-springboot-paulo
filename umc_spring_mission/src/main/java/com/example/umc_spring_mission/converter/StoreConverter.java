package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Neighborhood;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.web.dto.Store.StoreRequestDTO;
import com.example.umc_spring_mission.web.dto.Store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.AddStoreResponseDTO toAddStoreResponseDTO(Restaurant restaurant) {
        return StoreResponseDTO.AddStoreResponseDTO.builder()
                .restaurantId(restaurant.getRestaurantId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(StoreRequestDTO.AddStoreRequestDTO request, Neighborhood neighborhood) {

        return Restaurant.builder()
                .name(request.getName())
                .restaurantType(request.getRestaurantType())
                .restaurantAddress(request.getRestaurantAddress())
                .neighborhood(neighborhood)
                .build();
    }
}
