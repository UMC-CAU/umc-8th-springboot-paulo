package com.example.umc_spring_mission.repository.UserInfoRepository;

import com.example.umc_spring_mission.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<User, Long>, UserInfoRepositoryCustom {
}
