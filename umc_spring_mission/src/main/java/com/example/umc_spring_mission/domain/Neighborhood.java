package com.example.umc_spring_mission.domain;

import com.example.umc_spring_mission.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Neighborhood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long neighborhoodId;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false, length = 20)
    private String Name;

    @OneToMany(mappedBy = "neighborhood", cascade = CascadeType.ALL)
    private List<Restaurant> restaurantList = new ArrayList<>();

    @OneToMany(mappedBy = "neighborhood", cascade = CascadeType.ALL)
    private List<UserNeighborhood> userNeighborhoodList = new ArrayList<>();
}
