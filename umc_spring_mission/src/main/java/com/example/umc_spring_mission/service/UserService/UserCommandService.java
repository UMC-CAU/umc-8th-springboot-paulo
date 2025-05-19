package com.example.umc_spring_mission.service.UserService;

import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.web.dto.User.UserRequestDTO;

public interface UserCommandService {
    public User joinUser(UserRequestDTO.JoinDto request);
}
