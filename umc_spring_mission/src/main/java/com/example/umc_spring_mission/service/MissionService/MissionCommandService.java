package com.example.umc_spring_mission.service.MissionService;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDTO.AddMissionRequestDTO request, Long restaurantId);
}
