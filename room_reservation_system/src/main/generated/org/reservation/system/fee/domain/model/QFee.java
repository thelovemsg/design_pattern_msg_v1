package org.reservation.system.fee.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFee is a Querydsl query type for Fee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFee extends EntityPathBase<Fee> {

    private static final long serialVersionUID = 1938551314L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFee fee = new QFee("fee");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final ListPath<DailyRoomFee, QDailyRoomFee> dailyRoomFeeList = this.<DailyRoomFee, QDailyRoomFee>createList("dailyRoomFeeList", DailyRoomFee.class, QDailyRoomFee.class, PathInits.DIRECT2);

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final NumberPath<java.math.BigDecimal> feeAmount = createNumber("feeAmount", java.math.BigDecimal.class);

    public final StringPath feeName = createString("feeName");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath isUsed = createBoolean("isUsed");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final StringPath remark = createString("remark");

    public final org.reservation.system.room.domain.model.QRoomType roomType;

    public QFee(String variable) {
        this(Fee.class, forVariable(variable), INITS);
    }

    public QFee(Path<? extends Fee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFee(PathMetadata metadata, PathInits inits) {
        this(Fee.class, metadata, inits);
    }

    public QFee(Class<? extends Fee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roomType = inits.isInitialized("roomType") ? new org.reservation.system.room.domain.model.QRoomType(forProperty("roomType")) : null;
    }

}

