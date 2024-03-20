package org.reservation.system.room.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomAndRoomBlock;
import org.reservation.system.room.domain.model.RoomInfoHistory;


/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoom extends EntityPathBase<Room> {

    private static final long serialVersionUID = 1755982597L;

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

    public final ListPath<RoomFee, org.reservation.system.fee.domain.QRoomFee> roomFeeList = this.<RoomFee, org.reservation.system.fee.domain.QRoomFee>createList("roomFeeList", RoomFee.class, org.reservation.system.fee.domain.QRoomFee.class, PathInits.DIRECT2);

    public final ListPath<RoomInfoHistory, QRoomInfoHistory> roomInfoHistoryList = this.<RoomInfoHistory, QRoomInfoHistory>createList("roomInfoHistoryList", RoomInfoHistory.class, QRoomInfoHistory.class, PathInits.DIRECT2);

    public final StringPath roomName = createString("roomName");

    public final NumberPath<Integer> roomNo = createNumber("roomNo", Integer.class);

    public final ListPath<org.reservation.system.reservation.domain.other.RoomReservation, org.reservation.system.reservation.domain.other.QRoomReservation> roomReservationList = this.<org.reservation.system.reservation.domain.other.RoomReservation, org.reservation.system.reservation.domain.other.QRoomReservation>createList("roomReservationList", org.reservation.system.reservation.domain.other.RoomReservation.class, org.reservation.system.reservation.domain.other.QRoomReservation.class, PathInits.DIRECT2);

    public final ListPath<org.reservation.system.stay.domain.other.RoomStay, org.reservation.system.stay.domain.other.QRoomStay> roomStayList = this.<org.reservation.system.stay.domain.other.RoomStay, org.reservation.system.stay.domain.other.QRoomStay>createList("roomStayList", org.reservation.system.stay.domain.other.RoomStay.class, org.reservation.system.stay.domain.other.QRoomStay.class, PathInits.DIRECT2);

    public final StringPath roomType = createString("roomType");

    public QRoom(String variable) {
        super(Room.class, forVariable(variable));
    }

    public QRoom(Path<? extends Room> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoom(PathMetadata metadata) {
        super(Room.class, metadata);
    }

}

