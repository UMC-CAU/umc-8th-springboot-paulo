package com.example.umc_spring_mission.web.dto.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewResponseDTO {
        Long reviewId;
        Long userId;
        Long restaurantId;
        String text;
        int star;
    }
}
