package com.example.umc_spring_mission.web.controller;

import com.example.umc_spring_mission.apiPayload.ApiResponse;
import com.example.umc_spring_mission.converter.ReviewConverter;
import com.example.umc_spring_mission.converter.UserConverter;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.service.ReviewService.ReviewQueryService;
import com.example.umc_spring_mission.service.UserService.UserCommandService;
import com.example.umc_spring_mission.validation.annotation.ValidPage;
import com.example.umc_spring_mission.web.dto.Review.ReviewResponseDTO;
import com.example.umc_spring_mission.web.dto.User.UserRequestDTO;
import com.example.umc_spring_mission.web.dto.User.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "특정 유저의 리뷰 목록 조회 API", description = "특정 유저의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이지가 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getUserReviewList(@RequestParam(name = "page") @ValidPage Integer page){

        int newPage = page-1;
        Page<Review> reviewList = reviewQueryService.getReviewList(newPage);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }
}