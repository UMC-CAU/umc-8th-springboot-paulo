package com.example.umc_spring_mission.service.UserInfoService;

import com.example.umc_spring_mission.domain.User;
import com.example.umc_spring_mission.repository.UserInfoRepository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserInfoQueryServiceImpl implements UserInfoQueryService {

    private final UserInfoRepository userInfoRepository;
    @Override
    public Optional<User> findUserInfo(Long UserId) {
        return userInfoRepository.findById(UserId);
    }
}
