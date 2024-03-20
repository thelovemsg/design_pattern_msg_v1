package org.reservation.system.room.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import org.reservation.system.room.domain.model.RoomInfoHistory;


/**
 * QRoomInfoHistory is a Querydsl query type for RoomInfoHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomInfoHistory extends EntityPathBase<RoomInfoHistory> {

    private static final long serialVersionUID = -1954943039L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomInfoHistory roomInfoHistory = new QRoomInfoHistory("roomInfoHistory");

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

    public final StringPath reason = createString("reason");

    public final StringPath remark = createString("remark");

    public final QRoom room;

    public final StringPath roomStatus = createString("roomStatus");

    public QRoomInfoHistory(String variable) {
        this(RoomInfoHistory.class, forVariable(variable), INITS);
    }

    public QRoomInfoHistory(Path<? extends RoomInfoHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomInfoHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomInfoHistory(PathMetadata metadata, PathInits inits) {
        this(RoomInfoHistory.class, metadata, inits);
    }

    public QRoomInfoHistory(Class<? extends RoomInfoHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.room = inits.isInitialized("room") ? new QRoom(forProperty("room")) : null;
    }

}

