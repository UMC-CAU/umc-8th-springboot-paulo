package com.example.umc_spring_mission.repository.UserInfoRepository;

import com.example.umc_spring_mission.domain.User;

import java.util.List;

public interface UserInfoRepositoryCustom {
    User findUserInfoById(Long userId);
}
