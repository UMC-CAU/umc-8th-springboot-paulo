package com.example.umc_spring_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNeighborhood is a Querydsl query type for Neighborhood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNeighborhood extends EntityPathBase<Neighborhood> {

    private static final long serialVersionUID = -103288183L;

    public static final QNeighborhood neighborhood = new QNeighborhood("neighborhood");

    public final com.example.umc_spring_mission.domain.common.QBaseEntity _super = new com.example.umc_spring_mission.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> neighborhoodId = createNumber("neighborhoodId", Long.class);

    public final ListPath<Restaurant, QRestaurant> restaurantList = this.<Restaurant, QRestaurant>createList("restaurantList", Restaurant.class, QRestaurant.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<UserNeighborhood, QUserNeighborhood> userNeighborhoodList = this.<UserNeighborhood, QUserNeighborhood>createList("userNeighborhoodList", UserNeighborhood.class, QUserNeighborhood.class, PathInits.DIRECT2);

    public QNeighborhood(String variable) {
        super(Neighborhood.class, forVariable(variable));
    }

    public QNeighborhood(Path<? extends Neighborhood> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNeighborhood(PathMetadata metadata) {
        super(Neighborhood.class, metadata);
    }

}

