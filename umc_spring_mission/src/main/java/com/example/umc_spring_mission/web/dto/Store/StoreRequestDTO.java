package com.example.umc_spring_mission.web.dto.Store;

import com.example.umc_spring_mission.domain.enums.Type;
import com.example.umc_spring_mission.validation.annotation.ExistNeighborhood;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreRequestDTO {
        @ExistNeighborhood
        Long dongId;
        @NotBlank
        String name;
        @NotBlank
        String restaurantType;
        @NotBlank
        @Size(min = 2, max = 50)
        String restaurantAddress;
    }
}
