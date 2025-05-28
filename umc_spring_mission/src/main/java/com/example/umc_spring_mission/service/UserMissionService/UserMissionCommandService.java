package com.example.umc_spring_mission.service.UserMissionService;

import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionRequestDTO;

public interface UserMissionCommandService {
    public UserMission startMission(UserMissionRequestDTO.StartMissionDTO request, Long missionId);

    public UserMission successMission(Long userMissionId);
}
