package com.example.umc_spring_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserNeighborhood is a Querydsl query type for UserNeighborhood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserNeighborhood extends EntityPathBase<UserNeighborhood> {

    private static final long serialVersionUID = -1937791884L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserNeighborhood userNeighborhood = new QUserNeighborhood("userNeighborhood");

    public final com.example.umc_spring_mission.domain.common.QBaseEntity _super = new com.example.umc_spring_mission.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final NumberPath<Integer> missionCompleted = createNumber("missionCompleted", Integer.class);

    public final NumberPath<Integer> missionNeeded = createNumber("missionNeeded", Integer.class);

    public final QNeighborhood neighborhood;

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public final NumberPath<Long> userNeighborhoodId = createNumber("userNeighborhoodId", Long.class);

    public QUserNeighborhood(String variable) {
        this(UserNeighborhood.class, forVariable(variable), INITS);
    }

    public QUserNeighborhood(Path<? extends UserNeighborhood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserNeighborhood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserNeighborhood(PathMetadata metadata, PathInits inits) {
        this(UserNeighborhood.class, metadata, inits);
    }

    public QUserNeighborhood(Class<? extends UserNeighborhood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.neighborhood = inits.isInitialized("neighborhood") ? new QNeighborhood(forProperty("neighborhood")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

