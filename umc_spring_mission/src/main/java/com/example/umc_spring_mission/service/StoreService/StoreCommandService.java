package com.example.umc_spring_mission.service.StoreService;

import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService {
    public Restaurant addRestaurant (StoreRequestDTO.AddStoreRequestDTO request);
}
