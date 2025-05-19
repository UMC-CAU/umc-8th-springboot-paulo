package com.example.umc_spring_mission.service.MissionService.PosMissionService;

import com.querydsl.core.Tuple;

import java.util.List;

public interface PosMissionQueryService {
    List<Tuple> findPosMission(Long userId, String dongName);
}
