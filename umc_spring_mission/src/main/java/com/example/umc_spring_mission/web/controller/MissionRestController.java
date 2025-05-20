package com.example.umc_spring_mission.web.controller;

import com.example.umc_spring_mission.apiPayload.ApiResponse;
import com.example.umc_spring_mission.converter.UserMissionConverter;
import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.service.UserMissionService.UserMissionCommandService;
import com.example.umc_spring_mission.validation.annotation.AlreadyChallenging;
import com.example.umc_spring_mission.validation.annotation.ExistMission;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionRequestDTO;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {

    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/{missionId}/userMissions")
    public ApiResponse<UserMissionResponseDTO.StartMissionResultDTO>
    join(@RequestBody @Valid UserMissionRequestDTO.StartMissionDTO request , @PathVariable @Valid @ExistMission @AlreadyChallenging Long missionId) {
        UserMission userMission = userMissionCommandService.startMission(request, missionId);
        return ApiResponse.onSuccess(UserMissionConverter.toStartMissionResultDTO(userMission));
    }
}
