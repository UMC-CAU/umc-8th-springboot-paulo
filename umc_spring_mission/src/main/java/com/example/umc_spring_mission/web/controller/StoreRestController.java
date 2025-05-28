package com.example.umc_spring_mission.web.controller;

import com.example.umc_spring_mission.apiPayload.ApiResponse;
import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.apiPayload.exception.handler.UserHandler;
import com.example.umc_spring_mission.converter.MissionConverter;
import com.example.umc_spring_mission.converter.ReviewConverter;
import com.example.umc_spring_mission.converter.StoreConverter;
import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.repository.RestaurantRepository.RestaurantRepository;
import com.example.umc_spring_mission.service.MissionService.MissionCommandService;
import com.example.umc_spring_mission.service.MissionService.MissionQueryService;
import com.example.umc_spring_mission.service.ReviewService.ReviewCommandService;
import com.example.umc_spring_mission.service.ReviewService.ReviewQueryService;
import com.example.umc_spring_mission.service.StoreService.StoreCommandService;
import com.example.umc_spring_mission.validation.annotation.ExistRestaurant;
import com.example.umc_spring_mission.validation.annotation.ValidPage;
import com.example.umc_spring_mission.web.dto.Review.ReviewRequestDTO;
import com.example.umc_spring_mission.web.dto.Review.ReviewResponseDTO;
import com.example.umc_spring_mission.web.dto.Store.StoreRequestDTO;
import com.example.umc_spring_mission.web.dto.Store.StoreResponseDTO;
import com.example.umc_spring_mission.web.dto.mission.MissionRequestDTO;
import com.example.umc_spring_mission.web.dto.mission.MissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;

    private final ReviewQueryService reviewQueryService;
    private final MissionQueryService missionQueryService;


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

    @PostMapping("/{restaurantId}/missions")
    public ApiResponse<MissionResponseDTO.AddMissionResponseDTO>
    join(@PathVariable @ExistRestaurant @Valid Long restaurantId, @RequestBody @Valid MissionRequestDTO.AddMissionRequestDTO request){
        Mission mission = missionCommandService.addMission(request, restaurantId);

        return ApiResponse.onSuccess(MissionConverter.toAddMissionResponseDTO(mission));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "식당이 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이지가 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),

    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistRestaurant @Valid Long restaurantId, @RequestParam(name = "page") @ValidPage Integer page){
        page = page-1;

        Page<Review> reviewList = reviewQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{restaurantId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "RESTAURANT4001", description = "식당이 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이지가 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),

    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionList(@ExistRestaurant @Valid Long restaurantId, @RequestParam(name = "page") @ValidPage Integer page){
        page = page-1;

        Page<Mission> missionList = missionQueryService.getMissionList(restaurantId, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }
}
