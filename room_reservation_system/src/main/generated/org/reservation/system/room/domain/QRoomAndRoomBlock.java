package org.reservation.system.room.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import org.reservation.system.room.domain.model.RoomAndRoomBlock;


/**
 * QRoomAndRoomBlock is a Querydsl query type for RoomAndRoomBlock
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomAndRoomBlock extends EntityPathBase<RoomAndRoomBlock> {

    private static final long serialVersionUID = -174617600L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoomAndRoomBlock roomAndRoomBlock = new QRoomAndRoomBlock("roomAndRoomBlock");

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

    public final QRoom room;

    public final QRoomBlock roomBlock;

    public QRoomAndRoomBlock(String variable) {
        this(RoomAndRoomBlock.class, forVariable(variable), INITS);
    }

    public QRoomAndRoomBlock(Path<? extends RoomAndRoomBlock> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoomAndRoomBlock(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoomAndRoomBlock(PathMetadata metadata, PathInits inits) {
        this(RoomAndRoomBlock.class, metadata, inits);
    }

    public QRoomAndRoomBlock(Class<? extends RoomAndRoomBlock> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.room = inits.isInitialized("room") ? new QRoom(forProperty("room")) : null;
        this.roomBlock = inits.isInitialized("roomBlock") ? new QRoomBlock(forProperty("roomBlock")) : null;
    }

}

