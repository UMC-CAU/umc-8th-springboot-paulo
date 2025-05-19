package com.example.umc_spring_mission.web.dto.Store;

import com.example.umc_spring_mission.domain.enums.Type;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreRequestDTO {
        Long dongId;
        String name;
        String restaurantType;
        String restaurantAddress;
    }
}
