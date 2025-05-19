package com.example.umc_spring_mission.repository.StoreRespository;

import com.example.umc_spring_mission.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Restaurant, Long> {
}
