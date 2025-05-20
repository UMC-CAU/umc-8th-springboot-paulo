package com.example.umc_spring_mission.web.dto.UserMission;

import lombok.Getter;

public class UserMissionRequestDTO {

    @Getter
    public static class StartMissionDTO {
        Long userId = 1L;
    }
}
