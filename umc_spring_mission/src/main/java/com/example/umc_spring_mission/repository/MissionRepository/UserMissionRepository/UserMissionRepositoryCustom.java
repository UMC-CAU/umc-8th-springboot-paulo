package com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.UserMission;

import java.util.List;

public interface UserMissionRepositoryCustom {
    List<Mission> findMissionsForUser(Long userId, boolean isCompleted);
}
