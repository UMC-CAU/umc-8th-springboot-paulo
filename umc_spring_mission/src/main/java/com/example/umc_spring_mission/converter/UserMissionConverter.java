package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionRequestDTO;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionResponseDTO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMissionConverter {

    public static UserMissionResponseDTO.StartMissionResultDTO toStartMissionResultDTO(UserMission userMission) {
        return UserMissionResponseDTO.StartMissionResultDTO.builder()
                .userMissionId(userMission.getUserMissionId())
                .isSuccess(userMission.isSuccess())
                .userId(userMission.getUser().getUserId())
                .missionId(userMission.getMission().getMissionId())
                .build();
    }

    public static UserMission toUserMission(User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .build();
    }

    public static UserMissionResponseDTO.UserMissionPreViewDTO userMissionPreViewDTO(UserMission userMission){
        return UserMissionResponseDTO.UserMissionPreViewDTO.builder()
                .userMissionId(userMission.getUserMissionId())
                .missionDescription(userMission.getMission().getMissionDescription())
                .remainingDuration(userMission.getMission().getRemainingDuration())
                .restaurantName(userMission.getMission().getRestaurant().getName())
                .rewardPoints(userMission.getMission().getRewardPoint())
                .build();
    }

    public static UserMissionResponseDTO.UserMissionPreViewListDTO userMissionPreViewListDTO(Page<UserMission> userMissionList){
        List<UserMissionResponseDTO.UserMissionPreViewDTO> userMissionPreViewDTOList = userMissionList.stream()
                .map(UserMissionConverter::userMissionPreViewDTO).collect(Collectors.toList());
        return UserMissionResponseDTO.UserMissionPreViewListDTO.builder()
                .isFirst(userMissionList.isFirst())
                .isLast(userMissionList.isLast())
                .totalPage(userMissionList.getTotalPages())
                .totalElements(userMissionList.getTotalElements())
                .listSize(userMissionList.getNumberOfElements())
                .userMissionList(userMissionPreViewDTOList)
                .build();
    }

    public static UserMissionResponseDTO.UserMissionPatchResponseDTO userMissionPatchResponseDTO(UserMission userMission){
        return UserMissionResponseDTO.UserMissionPatchResponseDTO.builder()
                .userMissionId(userMission.getUserMissionId())
                .missionDescription(userMission.getMission().getMissionDescription())
                .remainingDuration(userMission.getMission().getRemainingDuration())
                .restaurantName(userMission.getMission().getRestaurant().getName())
                .rewardPoints(userMission.getMission().getRewardPoint())
                .isSuccess(userMission.isSuccess())
                .build();
    }
}
