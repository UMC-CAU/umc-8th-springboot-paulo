package com.example.umc_spring_mission.web.dto.UserMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StartMissionResultDTO {
        Long userMissionId;
        Boolean isSuccess;
        Long missionId;
        Long userId;
    }
}
