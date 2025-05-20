package com.example.umc_spring_mission.service.UserMissionService;

import com.example.umc_spring_mission.converter.MissionConverter;
import com.example.umc_spring_mission.converter.UserMissionConverter;
import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.repository.MissionRepository.MissionRepository;
import com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository.UserMissionRepository;
import com.example.umc_spring_mission.repository.UserRepository.UserRepository;
import com.example.umc_spring_mission.web.dto.UserMission.UserMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public UserMission startMission(UserMissionRequestDTO.StartMissionDTO request, Long missionId) {

        User user = userRepository.findById(request.getUserId()).get();
        Mission mission = missionRepository.findById(missionId).get();

        UserMission newUserMission = UserMissionConverter.toUserMission(user, mission);

        return userMissionRepository.save(newUserMission);
    }


}
