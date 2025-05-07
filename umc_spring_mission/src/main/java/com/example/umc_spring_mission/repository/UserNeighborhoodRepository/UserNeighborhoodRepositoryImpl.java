package com.example.umc_spring_mission.repository.UserNeighborhoodRepository;

import com.example.umc_spring_mission.domain.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserNeighborhoodRepositoryImpl implements UserNeighborhoodRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUserNeighborhood userNeighborhood = QUserNeighborhood.userNeighborhood;
    private final QNeighborhood neighborhood = QNeighborhood.neighborhood;

    @Override
    public UserNeighborhood findUserNeighborhoodById(Long userId, String dongName) {
        return jpaQueryFactory
                .selectFrom(userNeighborhood)
                .join(userNeighborhood.neighborhood, neighborhood)
                .where(userNeighborhood.user.userId.eq(userId)
                        .and(neighborhood.name.eq(dongName)))
                .fetchOne();
    }
}
