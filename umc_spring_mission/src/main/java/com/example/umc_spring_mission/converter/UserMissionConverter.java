package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionRequestDTO;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionResponseDTO;

public class UserMissionConverter {

    public static UserMissionResponseDTO.StartMissionResultDTO toStartMissionResultDTO(UserMission userMission) {
        return UserMissionResponseDTO.StartMissionResultDTO.builder()
                .userMissionId(userMission.getUserMissionId())
                .isSuccess(userMission.isSuccess())
                .userId(userMission.getUser().getUserId())
                .missionId(userMission.getMission().getMissionId())
                .build();
    }

    public static UserMission toUserMission(User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .build();
    }
}
