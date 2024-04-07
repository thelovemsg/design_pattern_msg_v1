package org.reservation.system.fee.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDailyRoomFee is a Querydsl query type for DailyRoomFee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDailyRoomFee extends EntityPathBase<DailyRoomFee> {

    private static final long serialVersionUID = -1125993658L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDailyRoomFee dailyRoomFee = new QDailyRoomFee("dailyRoomFee");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    public final TimePath<java.time.LocalTime> closeTime = createTime("closeTime", java.time.LocalTime.class);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath currentCode = createString("currentCode");

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final QFee fee;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final org.reservation.system.fee.value.QMoneyInfo moneyInfo;

    public final DatePath<java.time.LocalDate> occurDate = createDate("occurDate", java.time.LocalDate.class);

    public final ListPath<PricingHistory, QPricingHistory> pricingHistoryList = this.<PricingHistory, QPricingHistory>createList("pricingHistoryList", PricingHistory.class, QPricingHistory.class, PathInits.DIRECT2);

    public final org.reservation.system.reservation.domain.model.QReservation reservation;

    public QDailyRoomFee(String variable) {
        this(DailyRoomFee.class, forVariable(variable), INITS);
    }

    public QDailyRoomFee(Path<? extends DailyRoomFee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDailyRoomFee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDailyRoomFee(PathMetadata metadata, PathInits inits) {
        this(DailyRoomFee.class, metadata, inits);
    }

    public QDailyRoomFee(Class<? extends DailyRoomFee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fee = inits.isInitialized("fee") ? new QFee(forProperty("fee"), inits.get("fee")) : null;
        this.moneyInfo = inits.isInitialized("moneyInfo") ? new org.reservation.system.fee.value.QMoneyInfo(forProperty("moneyInfo")) : null;
        this.reservation = inits.isInitialized("reservation") ? new org.reservation.system.reservation.domain.model.QReservation(forProperty("reservation"), inits.get("reservation")) : null;
    }

}

