package com.example.umc_spring_mission.service.ReviewService;

import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.apiPayload.exception.handler.RestaurantHandler;
import com.example.umc_spring_mission.apiPayload.exception.handler.UserHandler;
import com.example.umc_spring_mission.converter.ReviewConverter;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.repository.RestaurantRepository.RestaurantRepository;
import com.example.umc_spring_mission.repository.ReviewRepository.ReviewRepository;
import com.example.umc_spring_mission.repository.UserRepository.UserRepository;
import com.example.umc_spring_mission.web.dto.Review.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Review addReview(ReviewRequestDTO.AddReviewRequestDTO request, Long restaurantId) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, user, restaurant);
        return reviewRepository.save(newReview);
    }
}
