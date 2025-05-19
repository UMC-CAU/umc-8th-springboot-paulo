package com.example.umc_spring_mission.service.ReviewService;

import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.web.dto.Review.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review addReview(ReviewRequestDTO.AddReviewRequestDTO request, Long restaurantId);
}
