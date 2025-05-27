package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.web.dto.Review.ReviewRequestDTO;
import com.example.umc_spring_mission.web.dto.Review.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .star(review.getStar())
                .createdAt(review.getCreatedAt())
                .body(review.getText())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
