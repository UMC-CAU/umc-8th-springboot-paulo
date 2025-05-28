package com.example.umc_spring_mission.repository.MissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
}
