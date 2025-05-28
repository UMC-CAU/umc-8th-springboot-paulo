package com.example.umc_spring_mission.web.controller;

import com.example.umc_spring_mission.apiPayload.ApiResponse;
import com.example.umc_spring_mission.converter.UserMissionConverter;
import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.service.UserMissionService.UserMissionCommandService;
import com.example.umc_spring_mission.service.UserMissionService.UserMissionQueryService;
import com.example.umc_spring_mission.validation.annotation.AlreadyChallenging;
import com.example.umc_spring_mission.validation.annotation.ExistMission;
import com.example.umc_spring_mission.validation.annotation.ValidPage;
import com.example.umc_spring_mission.validation.annotation.ValidUserMissionID;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionRequestDTO;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionResponseDTO;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {

    private final UserMissionCommandService userMissionCommandService;
    private final UserMissionQueryService userMissionQueryService;

    @PostMapping("/{missionId}/userMissions")
    public ApiResponse<UserMissionResponseDTO.StartMissionResultDTO>
    join(@RequestBody @Valid UserMissionRequestDTO.StartMissionDTO request , @PathVariable @Valid @ExistMission @AlreadyChallenging Long missionId) {
        UserMission userMission = userMissionCommandService.startMission(request, missionId);
        return ApiResponse.onSuccess(UserMissionConverter.toStartMissionResultDTO(userMission));
    }

    @GetMapping("/userMissions/{isSuccess}")
    @Operation(summary = "특정 유저의 진행중/완료인 미션 목록 조회 API", description = "특정 유저의 진행중/완료인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "페이지가 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "isSuccess", description = "미션의 성공 여부, path variable 입니다!")
    })
    public ApiResponse<UserMissionResponseDTO.UserMissionPreViewListDTO> getUMissionList(@PathVariable Boolean isSuccess, @RequestParam(name = "page") @ValidPage Integer page) {
        int newPage = page-1;
        Page<UserMission> userMissionList = userMissionQueryService.getUserMission(isSuccess, newPage);
        return ApiResponse.onSuccess(UserMissionConverter.userMissionPreViewListDTO(userMissionList));
    }

    @PatchMapping("/userMissions/{userMissionId}")
    @Operation(summary = "특정 유저의 미션 성공 여부 변경 API", description = "특정 유저의 미션들의 성공 여부를 변경하는 API이다")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "USERMISSION4001", description = "미션이 없음", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userMissionId", description = "유저 미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<UserMissionResponseDTO.UserMissionPatchResponseDTO> patchUMissionSuccess(@PathVariable @ValidUserMissionID Long userMissionId) {

        UserMission userMission = userMissionCommandService.successMission(userMissionId);
        return ApiResponse.onSuccess(UserMissionConverter.userMissionPatchResponseDTO(userMission));
    }
}
