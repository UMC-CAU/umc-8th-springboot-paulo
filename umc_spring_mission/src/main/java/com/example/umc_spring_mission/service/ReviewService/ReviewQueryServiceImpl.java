package com.example.umc_spring_mission.service.ReviewService;

import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.repository.RestaurantRepository.RestaurantRepository;
import com.example.umc_spring_mission.repository.ReviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return storePage;
    }
}
