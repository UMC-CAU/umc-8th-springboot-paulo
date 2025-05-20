package com.example.umc_spring_mission.web.dto.mission;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionRequestDTO {
        @NotBlank
        @Min(value = 24)
        int remainingDuration;
        @NotBlank
        @Min(value = 100)
        int rewardPoints;
        @NotBlank
        String missionDescription;
    }
}
