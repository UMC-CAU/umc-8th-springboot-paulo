package com.example.umc_spring_mission.service.MissionService;

import com.example.umc_spring_mission.converter.MissionConverter;
import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.repository.MissionRepository.MissionRepository;
import com.example.umc_spring_mission.repository.RestaurantRepository.RestaurantRepository;
import com.example.umc_spring_mission.web.dto.mission.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Mission addMission(MissionRequestDTO.AddMissionRequestDTO request, Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Mission newMission = MissionConverter.toMission(request, restaurant);

        return missionRepository.save(newMission);
    }
}
