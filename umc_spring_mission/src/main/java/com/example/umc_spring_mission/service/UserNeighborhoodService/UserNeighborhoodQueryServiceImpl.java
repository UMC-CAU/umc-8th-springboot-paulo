package com.example.umc_spring_mission.service.UserNeighborhoodService;

import com.example.umc_spring_mission.domain.UserNeighborhood;
import com.example.umc_spring_mission.repository.UserNeighborhoodRepository.UserNeighborhoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserNeighborhoodQueryServiceImpl implements UserNeighborhoodQueryService {

    private final UserNeighborhoodRepository userNeighborhoodRepository;

    @Override
    public Optional<UserNeighborhood> findUserNeighborhood(Long userId, String dongName) {
        return Optional.ofNullable(userNeighborhoodRepository.findUserNeighborhoodById(userId, dongName));
    }
}
