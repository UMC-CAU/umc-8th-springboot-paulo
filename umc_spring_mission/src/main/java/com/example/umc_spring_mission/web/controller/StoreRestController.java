package com.example.umc_spring_mission.web.controller;

import com.example.umc_spring_mission.apiPayload.ApiResponse;
import com.example.umc_spring_mission.converter.StoreConverter;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.service.StoreService.StoreCommandService;
import com.example.umc_spring_mission.web.dto.Store.StoreRequestDTO;
import com.example.umc_spring_mission.web.dto.Store.StoreResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping ("/")
    public ApiResponse<StoreResponseDTO.AddStoreResponseDTO>
    join(@RequestBody @Valid StoreRequestDTO.AddStoreRequestDTO request){
        Restaurant restaurant = storeCommandService.addRestaurant(request);
        return ApiResponse.onSuccess(StoreConverter.toAddStoreResponseDTO(restaurant));
    }
}
