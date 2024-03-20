package org.reservation.system.room.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomType is a Querydsl query type for RoomType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomType extends EntityPathBase<RoomType> {

    private static final long serialVersionUID = -233690748L;

    public static final QRoomType roomType = new QRoomType("roomType");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final ListPath<org.reservation.system.fee.domain.model.Fee, org.reservation.system.fee.domain.model.QFee> feeList = this.<org.reservation.system.fee.domain.model.Fee, org.reservation.system.fee.domain.model.QFee>createList("feeList", org.reservation.system.fee.domain.model.Fee.class, org.reservation.system.fee.domain.model.QFee.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final ListPath<Room, QRoom> roomList = this.<Room, QRoom>createList("roomList", Room.class, QRoom.class, PathInits.DIRECT2);

    public final StringPath roomTypeCd = createString("roomTypeCd");

    public QRoomType(String variable) {
        super(RoomType.class, forVariable(variable));
    }

    public QRoomType(Path<? extends RoomType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomType(PathMetadata metadata) {
        super(RoomType.class, metadata);
    }

}

