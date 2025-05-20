package com.example.umc_spring_mission.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResponseDTO {
        Long missionId;
        int remainingDuration;
        int rewardPoints;
        String missionDescription;
        Long restaurantId;
    }
}
