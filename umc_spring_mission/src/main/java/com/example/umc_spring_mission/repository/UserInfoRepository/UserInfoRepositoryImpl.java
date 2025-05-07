package com.example.umc_spring_mission.repository.UserInfoRepository;

import com.example.umc_spring_mission.domain.QUser;
import com.example.umc_spring_mission.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;

    @Override
    public User findUserInfoById(Long UserId) {
        return jpaQueryFactory
                .selectFrom(user)
                .where(user.userId.eq(UserId))
                .fetchOne();
    }
}
