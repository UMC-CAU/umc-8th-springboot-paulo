package com.example.umc_spring_mission.repository.MissionRepository.PosMissionRepository;

import com.example.umc_spring_mission.domain.QMission;
import com.example.umc_spring_mission.domain.QNeighborhood;
import com.example.umc_spring_mission.domain.QRestaurant;
import com.example.umc_spring_mission.domain.QUserMission;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PosMissionRepositoryImpl implements PosMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QNeighborhood neighborhood = QNeighborhood.neighborhood;
    private final QMission mission = QMission.mission;
    private final QRestaurant restaurant = QRestaurant.restaurant;
    private final QUserMission userMission = QUserMission.userMission;

    @Override
    public List<Tuple> findPosMission(Long userId, String dongName) {
        return jpaQueryFactory
                .select(
                        restaurant.name,
                        restaurant.restaurantType,
                        mission.remainingDuration,
                        mission.missionDescription,
                        mission.rewardPoint
                )
                .from(restaurant)
                .join(restaurant.neighborhood, neighborhood)
                .join(mission).on(restaurant.restaurantId.eq(mission.restaurant.restaurantId))
                .where(
                        neighborhood.name.eq(dongName)
                                .and(mission.missionId.notIn(
                                        JPAExpressions.select(userMission.mission.missionId)
                                                .from(userMission)
                                                .where(userMission.user.userId.eq(userId))
                                ))
                                .and(mission.remainingDuration.gt(0))
                )
                .fetch();
    }
}
