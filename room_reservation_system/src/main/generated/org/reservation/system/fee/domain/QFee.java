package org.reservation.system.fee.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import org.reservation.system.fee.domain.model.DailyRoomFee;
import org.reservation.system.fee.domain.model.Fee;


/**
 * QFee is a Querydsl query type for Fee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFee extends EntityPathBase<Fee> {

    private static final long serialVersionUID = -939322601L;

    public static final QFee fee = new QFee("fee");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    public final StringPath basisCd = createString("basisCd");

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final ListPath<DailyRoomFee, QDailyFee> dailyFeeList = this.<DailyRoomFee, QDailyFee>createList("dailyFeeList", DailyRoomFee.class, QDailyFee.class, PathInits.DIRECT2);

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

    public final StringPath peakDivCd = createString("peakDivCd");

    public final StringPath remark = createString("remark");

    public final ListPath<RoomFee, QRoomFee> roomFee = this.<RoomFee, QRoomFee>createList("roomFee", RoomFee.class, QRoomFee.class, PathInits.DIRECT2);

    public QFee(String variable) {
        super(Fee.class, forVariable(variable));
    }

    public QFee(Path<? extends Fee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFee(PathMetadata metadata) {
        super(Fee.class, metadata);
    }

}

