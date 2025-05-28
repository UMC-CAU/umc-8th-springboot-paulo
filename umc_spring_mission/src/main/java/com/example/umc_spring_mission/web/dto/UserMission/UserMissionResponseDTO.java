package com.example.umc_spring_mission.web.dto.UserMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserMissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StartMissionResultDTO {
        Long userMissionId;
        Boolean isSuccess;
        Long missionId;
        Long userId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionPreViewListDTO {
        List<UserMissionPreViewDTO> userMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionPreViewDTO {
        Long userMissionId;
        String missionDescription;
        int rewardPoints;
        int remainingDuration;
        String restaurantName;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMissionPatchResponseDTO {
        Long userMissionId;
        String missionDescription;
        int rewardPoints;
        int remainingDuration;
        Boolean isSuccess;
        String restaurantName;
    }

}
