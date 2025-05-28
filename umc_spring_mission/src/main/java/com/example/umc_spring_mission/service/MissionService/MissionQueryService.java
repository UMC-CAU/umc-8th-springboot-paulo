package com.example.umc_spring_mission.service.MissionService;

import com.example.umc_spring_mission.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<Mission> getMissionList(Long restaurantId, Integer page);
}
