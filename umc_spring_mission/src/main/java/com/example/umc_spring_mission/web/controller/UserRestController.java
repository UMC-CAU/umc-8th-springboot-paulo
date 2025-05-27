package com.example.umc_spring_mission.web.controller;

import com.example.umc_spring_mission.apiPayload.ApiResponse;
import com.example.umc_spring_mission.converter.ReviewConverter;
import com.example.umc_spring_mission.converter.UserConverter;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.service.ReviewService.ReviewQueryService;
import com.example.umc_spring_mission.service.UserService.UserCommandService;
import com.example.umc_spring_mission.web.dto.Review.ReviewResponseDTO;
import com.example.umc_spring_mission.web.dto.User.UserRequestDTO;
import com.example.umc_spring_mission.web.dto.User.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    private final UserCommandService userCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @GetMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getUserReviewList(@RequestParam(name = "page") Integer page){

        Page<Review> reviewList = reviewQueryService.getReviewList(page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }
}