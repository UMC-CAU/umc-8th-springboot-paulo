package com.example.umc_spring_mission.repository.ReviewRepository;

import com.example.umc_spring_mission.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
