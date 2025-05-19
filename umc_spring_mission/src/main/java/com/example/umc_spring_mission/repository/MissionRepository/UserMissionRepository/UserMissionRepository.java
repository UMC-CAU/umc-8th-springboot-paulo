package com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<Mission, Long>, UserMissionRepositoryCustom {
}
