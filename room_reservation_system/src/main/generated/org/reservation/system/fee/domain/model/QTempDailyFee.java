package org.reservation.system.fee.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTempDailyFee is a Querydsl query type for TempDailyFee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTempDailyFee extends EntityPathBase<TempDailyFee> {

    private static final long serialVersionUID = 994352533L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTempDailyFee tempDailyFee = new QTempDailyFee("tempDailyFee");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath feeName = createString("feeName");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final org.reservation.system.fee.value.QMoneyInfo moneyInfo;

    public final DatePath<java.time.LocalDate> occurDate = createDate("occurDate", java.time.LocalDate.class);

    public final TimePath<java.time.LocalTime> occurTime = createTime("occurTime", java.time.LocalTime.class);

    public final ListPath<PricingHistory, QPricingHistory> pricingHistoryList = this.<PricingHistory, QPricingHistory>createList("pricingHistoryList", PricingHistory.class, QPricingHistory.class, PathInits.DIRECT2);

    public final StringPath roomTypeCd = createString("roomTypeCd");

    public QTempDailyFee(String variable) {
        this(TempDailyFee.class, forVariable(variable), INITS);
    }

    public QTempDailyFee(Path<? extends TempDailyFee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTempDailyFee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTempDailyFee(PathMetadata metadata, PathInits inits) {
        this(TempDailyFee.class, metadata, inits);
    }

    public QTempDailyFee(Class<? extends TempDailyFee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.moneyInfo = inits.isInitialized("moneyInfo") ? new org.reservation.system.fee.value.QMoneyInfo(forProperty("moneyInfo")) : null;
    }

}

