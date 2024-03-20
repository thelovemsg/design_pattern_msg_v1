package org.reservation.system.stay.domain.other;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomStay is a Querydsl query type for RoomStay
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomStay extends EntityPathBase<RoomStay> {

    private static final long serialVersionUID = 2145633178L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomStay roomStay = new QRoomStay("roomStay");

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

    public final org.reservation.system.room.domain.model.QRoom room;

    public final org.reservation.system.stay.domain.QStay stay;

    public QRoomStay(String variable) {
        this(RoomStay.class, forVariable(variable), INITS);
    }

    public QRoomStay(Path<? extends RoomStay> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomStay(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomStay(PathMetadata metadata, PathInits inits) {
        this(RoomStay.class, metadata, inits);
    }

    public QRoomStay(Class<? extends RoomStay> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.room = inits.isInitialized("room") ? new org.reservation.system.room.domain.model.QRoom(forProperty("room"), inits.get("room")) : null;
        this.stay = inits.isInitialized("stay") ? new org.reservation.system.stay.domain.QStay(forProperty("stay"), inits.get("stay")) : null;
    }

}

