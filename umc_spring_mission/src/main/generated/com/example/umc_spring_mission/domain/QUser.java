package com.example.umc_spring_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1366449594L;

    public static final QUser user = new QUser("user");

    public final com.example.umc_spring_mission.domain.common.QBaseEntity _super = new com.example.umc_spring_mission.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<com.example.umc_spring_mission.domain.enums.Gender> gender = createEnum("gender", com.example.umc_spring_mission.domain.enums.Gender.class);

    public final DateTimePath<java.time.LocalDateTime> inactiveDate = createDateTime("inactiveDate", java.time.LocalDateTime.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phoneNum = createString("phoneNum");

    public final BooleanPath phoneNumVerification = createBoolean("phoneNumVerification");

    public final ListPath<PointTransaction, QPointTransaction> pointTransactionList = this.<PointTransaction, QPointTransaction>createList("pointTransactionList", PointTransaction.class, QPointTransaction.class, PathInits.DIRECT2);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<com.example.umc_spring_mission.domain.enums.Active> status = createEnum("status", com.example.umc_spring_mission.domain.enums.Active.class);

    public final NumberPath<Integer> totalPoint = createNumber("totalPoint", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<UserFood, QUserFood> userFoodList = this.<UserFood, QUserFood>createList("userFoodList", UserFood.class, QUserFood.class, PathInits.DIRECT2);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final ListPath<UserMission, QUserMission> userMissionList = this.<UserMission, QUserMission>createList("userMissionList", UserMission.class, QUserMission.class, PathInits.DIRECT2);

    public final ListPath<UserNeighborhood, QUserNeighborhood> userNeighborhoodList = this.<UserNeighborhood, QUserNeighborhood>createList("userNeighborhoodList", UserNeighborhood.class, QUserNeighborhood.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

