package com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.QMission;
import com.example.umc_spring_mission.domain.QRestaurant;
import com.example.umc_spring_mission.domain.QUserMission;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QUserMission userMission = QUserMission.userMission;
    private final QRestaurant restaurant = QRestaurant.restaurant;

    @Override
    public List<Tuple> findMissionsForUser(Long userId, Boolean complete) {
        StringTemplate cursorExpr = Expressions.stringTemplate(
                "CONCAT(LPAD({0},10,'0'), LPAD({1},10,'0'))",
                mission.remainingDuration, mission.missionId
        );

        return jpaQueryFactory
                .select(
                        mission.rewardPoint,
                        restaurant.name,
                        mission.missionDescription,
                        cursorExpr
                )
                .from(mission)
                .join(mission.restaurant, restaurant)
                .join(userMission).on(userMission.mission.missionId.eq(mission.missionId))
                .where(
                        mission.remainingDuration.gt(0),
                        userMission.user.userId.eq(userId),
                        userMission.isSuccess.eq(complete)
                )
                .orderBy(mission.remainingDuration.asc(), mission.missionId.asc())
                .limit(3)
                .fetch();
    }

}
