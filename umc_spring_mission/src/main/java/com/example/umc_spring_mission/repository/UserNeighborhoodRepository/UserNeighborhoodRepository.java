package com.example.umc_spring_mission.repository.UserNeighborhoodRepository;

import com.example.umc_spring_mission.domain.UserMission;
import com.example.umc_spring_mission.domain.UserNeighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNeighborhoodRepository extends JpaRepository<UserNeighborhood, Long>, UserNeighborhoodRepositoryCustom {

}
