package com.example.umc_spring_mission.domain;

import com.example.umc_spring_mission.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class UserNeighborhood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNeighborhoodId;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false)
    private Integer missionNeeded;

    @Column(nullable = false)
    private Integer missionCompleted;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isSuccess;

    @ManyToOne
    @JoinColumn(name = "neighborhood_id")
    private Neighborhood neighborhood;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
