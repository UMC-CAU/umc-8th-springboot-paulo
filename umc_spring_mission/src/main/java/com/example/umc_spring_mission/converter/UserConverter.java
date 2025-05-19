package com.example.umc_spring_mission.converter;

import com.example.umc_spring_mission.domain.Neighborhood;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.web.dto.User.UserRequestDTO;
import com.example.umc_spring_mission.web.dto.User.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toMember(UserRequestDTO.JoinDto request) {
        return User.builder()
                .name(request.getName())
                .phoneNum(request.getPhoneNum())
                .address(request.getAddress())
                .gender(request.getGender())
                .birth(request.getBirth())
                .phoneNumVerification(request.isPhoneNumVerification())
                .userFoodList(new ArrayList<>())
                .build();
    }
}