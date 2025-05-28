package com.example.umc_spring_mission.service.UserMissionService;

import com.example.umc_spring_mission.domain.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface UserMissionQueryService {
    Page<UserMission> getUserMission(Boolean isSuccess, Integer page);
}
