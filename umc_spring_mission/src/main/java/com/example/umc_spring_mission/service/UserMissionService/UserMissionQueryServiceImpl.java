package com.example.umc_spring_mission.service.UserMissionService;

import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository.UserMissionRepository;
import com.example.umc_spring_mission.repository.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionQueryServiceImpl implements UserMissionQueryService {
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;

    @Override
    public Page<UserMission> getUserMission(Boolean isSuccess, Integer page) {
        User user = userRepository.findById(1L).get();

        Page<UserMission> userMissionPage = userMissionRepository.findAllByUserIsSuccess(user, isSuccess, PageRequest.of(page, 10));

        return userMissionPage;
    }
}
