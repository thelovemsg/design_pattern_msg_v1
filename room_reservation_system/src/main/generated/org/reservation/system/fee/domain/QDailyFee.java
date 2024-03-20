package org.reservation.system.fee.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import org.reservation.system.fee.domain.model.DailyRoomFee;


/**
 * QDailyFee is a Querydsl query type for DailyFee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDailyFee extends EntityPathBase<DailyRoomFee> {

    private static final long serialVersionUID = -1093509700L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDailyFee dailyFee = new QDailyFee("dailyFee");

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

    public final org.reservation.system.fee.value.QMoney money;

    public final DatePath<java.time.LocalDate> occurDate = createDate("occurDate", java.time.LocalDate.class);

    public final org.reservation.system.reservation.domain.QReservation reservation;

    public QDailyFee(String variable) {
        this(DailyRoomFee.class, forVariable(variable), INITS);
    }

    public QDailyFee(Path<? extends DailyRoomFee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDailyFee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDailyFee(PathMetadata metadata, PathInits inits) {
        this(DailyRoomFee.class, metadata, inits);
    }

    public QDailyFee(Class<? extends DailyRoomFee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fee = inits.isInitialized("fee") ? new QFee(forProperty("fee")) : null;
        this.money = inits.isInitialized("money") ? new org.reservation.system.fee.value.QMoney(forProperty("money")) : null;
        this.reservation = inits.isInitialized("reservation") ? new org.reservation.system.reservation.domain.QReservation(forProperty("reservation"), inits.get("reservation")) : null;
    }

}

