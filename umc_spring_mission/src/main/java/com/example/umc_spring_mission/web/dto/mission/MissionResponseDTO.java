package com.example.umc_spring_mission.web.dto.mission;

import com.example.umc_spring_mission.web.dto.Review.ReviewResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResponseDTO {
        Long missionId;
        int remainingDuration;
        int rewardPoints;
        String missionDescription;
        Long restaurantId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        List<MissionResponseDTO.MissionPreViewDTO> missionList;
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
    public static class MissionPreViewDTO {
        Long missionId;
        String missionDescription;
        int rewardPoints;
        int remainingDuration;
        String restaurantName;
    }
}
