package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.web.dto.Review.ReviewRequestDTO;
import com.example.umc_spring_mission.web.dto.Review.ReviewResponseDTO;

public class ReviewConverter {
    public static ReviewResponseDTO.AddReviewResponseDTO toAddReviewResponseDTO(Review review) {
        return ReviewResponseDTO.AddReviewResponseDTO.builder()
                .reviewId(review.getReviewId())
                .restaurantId(review.getRestaurant().getRestaurantId())
                .userId(review.getUser().getUserId())
                .star(review.getStar())
                .text(review.getText())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewRequestDTO request, User user, Restaurant restaurant) {
        return Review.builder()
                .star(request.getStar())
                .text(request.getText())
                .user(user)
                .restaurant(restaurant)
                .build();
    }
}
