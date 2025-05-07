package com.example.umc_spring_mission.repository.UserNeighborhoodRepository;

import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.domain.UserNeighborhood;

public interface UserNeighborhoodRepositoryCustom {
    UserNeighborhood findUserNeighborhoodById(Long userId, String dongName);
}
