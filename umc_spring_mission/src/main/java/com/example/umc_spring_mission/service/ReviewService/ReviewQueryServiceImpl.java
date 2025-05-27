package com.example.umc_spring_mission.service.ReviewService;

import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.repository.RestaurantRepository.RestaurantRepository;
import com.example.umc_spring_mission.repository.ReviewRepository.ReviewRepository;
import com.example.umc_spring_mission.repository.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(storeId).get();

        Page<Review> storePage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return storePage;
    }

    @Override
    public Page<Review> getReviewList(Integer page) {
        User user = userRepository.findById(1L).get();

        Page<Review> userPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return userPage;
    }
}
