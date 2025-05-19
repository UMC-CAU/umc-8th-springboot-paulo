package com.example.umc_spring_mission.web.dto.Review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewRequestDTO {
        @Max(5)
        @NotNull
        int star;
        @Size(max = 50)
        @NotBlank
        String text;
        Long userId = 1L;
    }
}
