package com.example.umc_spring_mission.repository.MissionRepository.UserMissionRepository;

import com.example.umc_spring_mission.domain.Mission;
import com.example.umc_spring_mission.domain.QMission;
import com.example.umc_spring_mission.domain.QRestaurant;
import com.example.umc_spring_mission.domain.QUserMission;
import com.querydsl.core.types.dsl.BooleanExpression;
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
    public List<Mission> findMissionsForUser(Long userId, boolean isCompleted) {
        int size = 10;  // 페이지 크기를 10으로 고정

        // 'isCompleted'가 true일 경우, 'isSuccess'가 true인 미션만 가져오고
        // 'isCompleted'가 false일 경우, 'isSuccess'가 false인 미션만 가져옵니다.
        BooleanExpression isSuccessCondition = isCompleted ? userMission.isSuccess.isTrue() : userMission.isSuccess.isFalse();
        StringExpression subQuery = mission.remainingDuration.stringValue().concat(mission.missionId.stringValue());
        return jpaQueryFactory
                .select(mission.rewardPoint, restaurant.name, mission.missionDescription,
                        mission.remainingDuration.stringValue().padLeft(10, '0').concat(mission.missionId.stringValue().padLeft(10, '0')))
                .from(mission)
                .join(userMission).on(userMission.mission.missionId.eq(mission.missionId))
                .join(restaurant).on(restaurant.restaurantId.eq(mission.restaurant.restaurantId))
                .where(userMission.user.userId.eq(userId)
                        .and(mission.remainingDuration.gt(0))
                        .and(isSuccessCondition) // 동적으로 필터링
                        .and(mission.remainingDuration.stringValue().concat(mission.missionId.stringValue())
                                .goe(subQuery))) // 기존 서브쿼리와 결합
                .orderBy(mission.remainingDuration.asc(), mission.missionId.asc())
                .limit(size)  // 한 번에 최대 10개 데이터만 반환
                .fetch();
    }
}
