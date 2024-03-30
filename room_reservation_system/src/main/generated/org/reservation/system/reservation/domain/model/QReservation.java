package org.reservation.system.reservation.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = 662011346L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservation reservation = new QReservation("reservation");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final ListPath<org.reservation.system.fee.domain.model.DailyRoomFee, org.reservation.system.fee.domain.model.QDailyRoomFee> dailyRoomFeeList = this.<org.reservation.system.fee.domain.model.DailyRoomFee, org.reservation.system.fee.domain.model.QDailyRoomFee>createList("dailyRoomFeeList", org.reservation.system.fee.domain.model.DailyRoomFee.class, org.reservation.system.fee.domain.model.QDailyRoomFee.class, PathInits.DIRECT2);

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    public final ListPath<org.reservation.system.message.domain.Message, org.reservation.system.message.domain.QMessage> messageList = this.<org.reservation.system.message.domain.Message, org.reservation.system.message.domain.QMessage>createList("messageList", org.reservation.system.message.domain.Message.class, org.reservation.system.message.domain.QMessage.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final ListPath<ReservationHistory, QReservationHistory> reservationHistoryList = this.<ReservationHistory, QReservationHistory>createList("reservationHistoryList", ReservationHistory.class, QReservationHistory.class, PathInits.DIRECT2);

    public final org.reservation.system.reservation.domain.model.value.QReservationInfo reservationInfo;

    public final StringPath reservationMethod = createString("reservationMethod");

    public final ListPath<org.reservation.system.reservation.domain.model.other.RoomReservation, org.reservation.system.reservation.domain.model.other.QRoomReservation> roomReservationList = this.<org.reservation.system.reservation.domain.model.other.RoomReservation, org.reservation.system.reservation.domain.model.other.QRoomReservation>createList("roomReservationList", org.reservation.system.reservation.domain.model.other.RoomReservation.class, org.reservation.system.reservation.domain.model.other.QRoomReservation.class, PathInits.DIRECT2);

    public final org.reservation.system.stay.domain.QStay stay;

    public QReservation(String variable) {
        this(Reservation.class, forVariable(variable), INITS);
    }

    public QReservation(Path<? extends Reservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservation(PathMetadata metadata, PathInits inits) {
        this(Reservation.class, metadata, inits);
    }

    public QReservation(Class<? extends Reservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservationInfo = inits.isInitialized("reservationInfo") ? new org.reservation.system.reservation.domain.model.value.QReservationInfo(forProperty("reservationInfo")) : null;
        this.stay = inits.isInitialized("stay") ? new org.reservation.system.stay.domain.QStay(forProperty("stay"), inits.get("stay")) : null;
    }

}

