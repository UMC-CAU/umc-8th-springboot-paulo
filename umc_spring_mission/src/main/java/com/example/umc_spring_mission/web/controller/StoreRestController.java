package com.example.umc_spring_mission.web.controller;

import com.example.umc_spring_mission.apiPayload.ApiResponse;
import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.apiPayload.exception.handler.UserHandler;
import com.example.umc_spring_mission.converter.ReviewConverter;
import com.example.umc_spring_mission.converter.StoreConverter;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.repository.RestaurantRepository.RestaurantRepository;
import com.example.umc_spring_mission.service.ReviewService.ReviewCommandService;
import com.example.umc_spring_mission.service.StoreService.StoreCommandService;
import com.example.umc_spring_mission.validation.annotation.ExistRestaurant;
import com.example.umc_spring_mission.web.dto.Review.ReviewRequestDTO;
import com.example.umc_spring_mission.web.dto.Review.ReviewResponseDTO;
import com.example.umc_spring_mission.web.dto.Store.StoreRequestDTO;
import com.example.umc_spring_mission.web.dto.Store.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;


    @PostMapping ("/")
    public ApiResponse<StoreResponseDTO.AddStoreResponseDTO>
    join(@RequestBody @Valid StoreRequestDTO.AddStoreRequestDTO request){
        Restaurant restaurant = storeCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResponseDTO(restaurant));
    }

    @PostMapping("/{restaurantId}/reviews")
    public ApiResponse<ReviewResponseDTO.AddReviewResponseDTO>
    join(@PathVariable @ExistRestaurant @Valid Long restaurantId, @RequestBody @Valid ReviewRequestDTO.AddReviewRequestDTO request){
        Review review = reviewCommandService.addReview(request,restaurantId);

        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResponseDTO(review));
    }
}
