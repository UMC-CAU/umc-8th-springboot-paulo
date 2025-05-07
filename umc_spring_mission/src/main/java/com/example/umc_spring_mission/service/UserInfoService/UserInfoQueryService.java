package com.example.umc_spring_mission.service.UserInfoService;

import com.example.umc_spring_mission.domain.QUser;
import com.example.umc_spring_mission.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserInfoQueryService {
    Optional<User> findUserInfo(Long UserId);
}
