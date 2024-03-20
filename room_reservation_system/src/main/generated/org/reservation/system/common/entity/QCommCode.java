package org.reservation.system.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommCode is a Querydsl query type for CommCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommCode extends EntityPathBase<CommCode> {

    private static final long serialVersionUID = -397788076L;

    public static final QCommCode commCode = new QCommCode("commCode");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath displayCode = createString("displayCode");

    public final StringPath displayName = createString("displayName");

    public final StringPath groupCode = createString("groupCode");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lang = createString("lang");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public QCommCode(String variable) {
        super(CommCode.class, forVariable(variable));
    }

    public QCommCode(Path<? extends CommCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommCode(PathMetadata metadata) {
        super(CommCode.class, metadata);
    }

}

