package com.example.umc_spring_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPointTransaction is a Querydsl query type for PointTransaction
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPointTransaction extends EntityPathBase<PointTransaction> {

    private static final long serialVersionUID = -1028923095L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPointTransaction pointTransaction = new QPointTransaction("pointTransaction");

    public final com.example.umc_spring_mission.domain.common.QBaseEntity _super = new com.example.umc_spring_mission.domain.common.QBaseEntity(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> transactionId = createNumber("transactionId", Long.class);

    public final EnumPath<com.example.umc_spring_mission.domain.enums.TransactionType> transactionType = createEnum("transactionType", com.example.umc_spring_mission.domain.enums.TransactionType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QPointTransaction(String variable) {
        this(PointTransaction.class, forVariable(variable), INITS);
    }

    public QPointTransaction(Path<? extends PointTransaction> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPointTransaction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPointTransaction(PathMetadata metadata, PathInits inits) {
        this(PointTransaction.class, metadata, inits);
    }

    public QPointTransaction(Class<? extends PointTransaction> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

