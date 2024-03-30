package org.reservation.system.stay.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStay is a Querydsl query type for Stay
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStay extends EntityPathBase<Stay> {

    private static final long serialVersionUID = -544675583L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStay stay = new QStay("stay");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    public final StringPath checkinDivCd = createString("checkinDivCd");

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

    public final org.reservation.system.reservation.domain.model.QReservation reservation;

    public final org.reservation.system.reservation.domain.model.value.QReservationInfo reservationInfo;

    public final ListPath<org.reservation.system.stay.domain.other.RoomStay, org.reservation.system.stay.domain.other.QRoomStay> roomStayList = this.<org.reservation.system.stay.domain.other.RoomStay, org.reservation.system.stay.domain.other.QRoomStay>createList("roomStayList", org.reservation.system.stay.domain.other.RoomStay.class, org.reservation.system.stay.domain.other.QRoomStay.class, PathInits.DIRECT2);

    public final ListPath<StayHistory, QStayHistory> stayHistoryList = this.<StayHistory, QStayHistory>createList("stayHistoryList", StayHistory.class, QStayHistory.class, PathInits.DIRECT2);

    public QStay(String variable) {
        this(Stay.class, forVariable(variable), INITS);
    }

    public QStay(Path<? extends Stay> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStay(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStay(PathMetadata metadata, PathInits inits) {
        this(Stay.class, metadata, inits);
    }

    public QStay(Class<? extends Stay> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservation = inits.isInitialized("reservation") ? new org.reservation.system.reservation.domain.model.QReservation(forProperty("reservation"), inits.get("reservation")) : null;
        this.reservationInfo = inits.isInitialized("reservationInfo") ? new org.reservation.system.reservation.domain.model.value.QReservationInfo(forProperty("reservationInfo")) : null;
    }

}

