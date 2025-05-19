package com.example.umc_spring_mission.repository.MissionRepository.PosMissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import com.querydsl.core.Tuple;

import java.util.List;

public interface PosMissionRepositoryCustom {
    List<Tuple> findPosMission(Long userId, String dongName);
}
