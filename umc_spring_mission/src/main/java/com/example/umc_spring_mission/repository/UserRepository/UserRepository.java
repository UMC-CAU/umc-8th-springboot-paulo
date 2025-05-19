package com.example.umc_spring_mission.repository.UserRepository;

import com.example.umc_spring_mission.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
