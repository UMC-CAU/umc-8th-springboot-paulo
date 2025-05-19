package com.example.umc_spring_mission.repository.RestaurantRepository;

import com.example.umc_spring_mission.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
