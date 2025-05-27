package com.example.umc_spring_mission.service.MissionService;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.repository.MissionRepository.MissionRepository;
import com.example.umc_spring_mission.repository.RestaurantRepository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMissionList(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Mission> missionPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return missionPage;
    }
}
