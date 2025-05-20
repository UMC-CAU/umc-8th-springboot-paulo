package com.example.umc_spring_mission.repository.MissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
