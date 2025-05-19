package com.example.umc_spring_mission.repository.MissionRepository.PosMissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosMissionRepository extends JpaRepository<Mission, Long>, PosMissionRepositoryCustom
{
}
