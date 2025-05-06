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

public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String restaurantType;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String restaurantAddress;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "dong_id")
    private Neighborhood neighborhood;
}
