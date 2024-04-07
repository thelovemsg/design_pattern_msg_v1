package org.reservation.system.fee.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPricingHistory is a Querydsl query type for PricingHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPricingHistory extends EntityPathBase<PricingHistory> {

    private static final long serialVersionUID = -527959070L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPricingHistory pricingHistory = new QPricingHistory("pricingHistory");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    public final NumberPath<java.math.BigDecimal> appliedPrice = createNumber("appliedPrice", java.math.BigDecimal.class);

    public final StringPath applyReason = createString("applyReason");

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final QDailyRoomFee dailyRoomFee;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final EnumPath<org.reservation.system.fee.application.enums.ChargeEnum> pricingType = createEnum("pricingType", org.reservation.system.fee.application.enums.ChargeEnum.class);

    public final QTempDailyFee tempDailyFee;

    public QPricingHistory(String variable) {
        this(PricingHistory.class, forVariable(variable), INITS);
    }

    public QPricingHistory(Path<? extends PricingHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPricingHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPricingHistory(PathMetadata metadata, PathInits inits) {
        this(PricingHistory.class, metadata, inits);
    }

    public QPricingHistory(Class<? extends PricingHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dailyRoomFee = inits.isInitialized("dailyRoomFee") ? new QDailyRoomFee(forProperty("dailyRoomFee"), inits.get("dailyRoomFee")) : null;
        this.tempDailyFee = inits.isInitialized("tempDailyFee") ? new QTempDailyFee(forProperty("tempDailyFee"), inits.get("tempDailyFee")) : null;
    }

}

