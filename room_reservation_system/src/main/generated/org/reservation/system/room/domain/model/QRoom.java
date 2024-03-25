package org.reservation.system.room.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoom extends EntityPathBase<Room> {

    private static final long serialVersionUID = -696792278L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoom room = new QRoom("room");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final StringPath remark = createString("remark");

    public final ListPath<RoomAndRoomBlock, QRoomAndRoomBlock> roomAndRoomBlockList = this.<RoomAndRoomBlock, QRoomAndRoomBlock>createList("roomAndRoomBlockList", RoomAndRoomBlock.class, QRoomAndRoomBlock.class, PathInits.DIRECT2);

    public final ListPath<RoomInfoHistory, QRoomInfoHistory> roomInfoHistoryList = this.<RoomInfoHistory, QRoomInfoHistory>createList("roomInfoHistoryList", RoomInfoHistory.class, QRoomInfoHistory.class, PathInits.DIRECT2);

    public final StringPath roomName = createString("roomName");

    public final NumberPath<Integer> roomNo = createNumber("roomNo", Integer.class);

    public final ListPath<org.reservation.system.reservation.domain.model.other.RoomReservation, org.reservation.system.reservation.domain.model.other.QRoomReservation> roomReservationList = this.<org.reservation.system.reservation.domain.model.other.RoomReservation, org.reservation.system.reservation.domain.model.other.QRoomReservation>createList("roomReservationList", org.reservation.system.reservation.domain.model.other.RoomReservation.class, org.reservation.system.reservation.domain.model.other.QRoomReservation.class, PathInits.DIRECT2);

    public final ListPath<org.reservation.system.stay.domain.other.RoomStay, org.reservation.system.stay.domain.other.QRoomStay> roomStayList = this.<org.reservation.system.stay.domain.other.RoomStay, org.reservation.system.stay.domain.other.QRoomStay>createList("roomStayList", org.reservation.system.stay.domain.other.RoomStay.class, org.reservation.system.stay.domain.other.QRoomStay.class, PathInits.DIRECT2);

    public final QRoomType roomType;

    public QRoom(String variable) {
        this(Room.class, forVariable(variable), INITS);
    }

    public QRoom(Path<? extends Room> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoom(PathMetadata metadata, PathInits inits) {
        this(Room.class, metadata, inits);
    }

    public QRoom(Class<? extends Room> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roomType = inits.isInitialized("roomType") ? new QRoomType(forProperty("roomType")) : null;
    }

}

