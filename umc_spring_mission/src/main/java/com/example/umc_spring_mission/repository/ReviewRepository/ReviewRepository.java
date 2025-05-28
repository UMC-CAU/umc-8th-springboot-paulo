package com.example.umc_spring_mission.repository.ReviewRepository;

import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.domain.Review;
import com.example.umc_spring_mission.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(
            value = "SELECT r FROM Review r JOIN FETCH r.user WHERE r.restaurant = :restaurant",
            countQuery = "SELECT COUNT(r) FROM Review r WHERE r.restaurant = :restaurant"
    )
    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

    @Query(
            value = "SELECT r FROM Review r JOIN FETCH r.user WHERE r.user = :user",
            countQuery = "SELECT COUNT(r) FROM Review r WHERE r.user = :user"
    )
    Page<Review> findAllByUser(User user, PageRequest pageRequest);
}
