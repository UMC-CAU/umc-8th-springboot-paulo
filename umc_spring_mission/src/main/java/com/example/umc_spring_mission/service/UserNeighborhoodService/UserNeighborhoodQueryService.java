package com.example.umc_spring_mission.service.UserNeighborhoodService;

import com.example.umc_spring_mission.domain.UserNeighborhood;

import java.util.Optional;

public interface UserNeighborhoodQueryService {
    Optional<UserNeighborhood> findUserNeighborhood(Long userId, String dongName);
}
