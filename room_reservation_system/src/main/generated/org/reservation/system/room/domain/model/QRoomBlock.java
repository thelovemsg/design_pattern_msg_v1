package org.reservation.system.room.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoomBlock is a Querydsl query type for RoomBlock
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomBlock extends EntityPathBase<RoomBlock> {

    private static final long serialVersionUID = 1328509827L;

    public static final QRoomBlock roomBlock = new QRoomBlock("roomBlock");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    public final DateTimePath<java.time.ZonedDateTime> blockEndDate = createDateTime("blockEndDate", java.time.ZonedDateTime.class);

    public final DateTimePath<java.time.ZonedDateTime> blockEndPlanDate = createDateTime("blockEndPlanDate", java.time.ZonedDateTime.class);

    public final DateTimePath<java.time.ZonedDateTime> blockStartDate = createDateTime("blockStartDate", java.time.ZonedDateTime.class);

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

    public final ListPath<RoomAndRoomBlock, QRoomAndRoomBlock> roomAndRoomBlock = this.<RoomAndRoomBlock, QRoomAndRoomBlock>createList("roomAndRoomBlock", RoomAndRoomBlock.class, QRoomAndRoomBlock.class, PathInits.DIRECT2);

    public final StringPath roomBlockType = createString("roomBlockType");

    public QRoomBlock(String variable) {
        super(RoomBlock.class, forVariable(variable));
    }

    public QRoomBlock(Path<? extends RoomBlock> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomBlock(PathMetadata metadata) {
        super(RoomBlock.class, metadata);
    }

}

