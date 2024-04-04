package org.reservation.system.fee.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiscount is a Querydsl query type for Discount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDiscount extends EntityPathBase<Discount> {

    private static final long serialVersionUID = 1077167669L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiscount discount = new QDiscount("discount");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final QDailyRoomFee dailyRoomFee;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final NumberPath<java.math.BigDecimal> discountedAmount = createNumber("discountedAmount", java.math.BigDecimal.class);

    public final StringPath discountType = createString("discountType");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final StringPath reason = createString("reason");

    public final QTempDailyFee tempDailyFee;

    public QDiscount(String variable) {
        this(Discount.class, forVariable(variable), INITS);
    }

    public QDiscount(Path<? extends Discount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDiscount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDiscount(PathMetadata metadata, PathInits inits) {
        this(Discount.class, metadata, inits);
    }

    public QDiscount(Class<? extends Discount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dailyRoomFee = inits.isInitialized("dailyRoomFee") ? new QDailyRoomFee(forProperty("dailyRoomFee"), inits.get("dailyRoomFee")) : null;
        this.tempDailyFee = inits.isInitialized("tempDailyFee") ? new QTempDailyFee(forProperty("tempDailyFee"), inits.get("tempDailyFee")) : null;
    }

}

