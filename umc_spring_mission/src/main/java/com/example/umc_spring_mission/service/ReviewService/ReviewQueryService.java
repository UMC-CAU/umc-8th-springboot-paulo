package com.example.umc_spring_mission.service.ReviewService;

import com.example.umc_spring_mission.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {

    Page<Review> getReviewList(Long storeId, Integer page);
}
