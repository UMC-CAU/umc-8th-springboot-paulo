package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.web.dto.mission.MissionRequestDTO;
import com.example.umc_spring_mission.web.dto.mission.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.AddMissionResponseDTO toAddMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResponseDTO.builder()
                .missionId(mission.getMissionId())
                .remainingDuration(mission.getRemainingDuration())
                .rewardPoints(mission.getRewardPoint())
                .missionDescription(mission.getMissionDescription())
                .restaurantId(mission.getRestaurant().getRestaurantId())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMissionRequestDTO request, Restaurant restaurant) {
        return Mission.builder()
                .remainingDuration(request.getRemainingDuration())
                .missionDescription(request.getMissionDescription())
                .rewardPoint(request.getRewardPoints())
                .restaurant(restaurant)
                .build();
    }
}