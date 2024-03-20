package org.reservation.system.reservation.domain.other;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomReservation is a Querydsl query type for RoomReservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomReservation extends EntityPathBase<RoomReservation> {

    private static final long serialVersionUID = -891715362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomReservation roomReservation = new QRoomReservation("roomReservation");

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

    public final org.reservation.system.reservation.domain.model.QReservation reservation;

    public final org.reservation.system.room.domain.model.QRoom room;

    public QRoomReservation(String variable) {
        this(RoomReservation.class, forVariable(variable), INITS);
    }

    public QRoomReservation(Path<? extends RoomReservation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomReservation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomReservation(PathMetadata metadata, PathInits inits) {
        this(RoomReservation.class, metadata, inits);
    }

    public QRoomReservation(Class<? extends RoomReservation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservation = inits.isInitialized("reservation") ? new org.reservation.system.reservation.domain.model.QReservation(forProperty("reservation"), inits.get("reservation")) : null;
        this.room = inits.isInitialized("room") ? new org.reservation.system.room.domain.model.QRoom(forProperty("room"), inits.get("room")) : null;
    }

}

