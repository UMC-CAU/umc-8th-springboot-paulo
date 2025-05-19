package com.example.umc_spring_mission.service.MissionService.PosMissionService;

import com.example.umc_spring_mission.repository.MissionRepository.PosMissionRepository.PosMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.querydsl.core.Tuple;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PosMissionQueryServiceImpl implements PosMissionQueryService {

    private final PosMissionRepository posMissionRepository;

    @Override
    public List<Tuple> findPosMission(Long userId, String dongName) {
        return posMissionRepository.findPosMission(userId, dongName);
    }
}
