package org.reservation.system.fee.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomFee is a Querydsl query type for RoomFee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomFee extends EntityPathBase<RoomFee> {

    private static final long serialVersionUID = -1474267204L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomFee roomFee = new QRoomFee("roomFee");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final QFee fee;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final org.reservation.system.room.domain.QRoom room;

    public QRoomFee(String variable) {
        this(RoomFee.class, forVariable(variable), INITS);
    }

    public QRoomFee(Path<? extends RoomFee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomFee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomFee(PathMetadata metadata, PathInits inits) {
        this(RoomFee.class, metadata, inits);
    }

    public QRoomFee(Class<? extends RoomFee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fee = inits.isInitialized("fee") ? new QFee(forProperty("fee")) : null;
        this.room = inits.isInitialized("room") ? new org.reservation.system.room.domain.QRoom(forProperty("room")) : null;
    }

}

