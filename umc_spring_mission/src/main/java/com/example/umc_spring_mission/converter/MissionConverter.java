package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.web.dto.mission.MissionRequestDTO;
import com.example.umc_spring_mission.web.dto.mission.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getMissionId())
                .remainingDuration(mission.getRemainingDuration())
                .rewardPoints(mission.getRewardPoint())
                .missionDescription(mission.getMissionDescription())
                .restaurantName(mission.getRestaurant().getName())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionList.getSize())
                .missionList(missionPreViewDTOList)
                .build();
    }
}