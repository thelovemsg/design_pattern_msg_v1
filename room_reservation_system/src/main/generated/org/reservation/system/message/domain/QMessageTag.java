package org.reservation.system.message.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessageTag is a Querydsl query type for MessageTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessageTag extends EntityPathBase<MessageTag> {

    private static final long serialVersionUID = 222449955L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMessageTag messageTag = new QMessageTag("messageTag");

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

    public final QMessage message;

    public final QMessageTemplate messageTemplate;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final StringPath sequence = createString("sequence");

    public final StringPath value = createString("value");

    public QMessageTag(String variable) {
        this(MessageTag.class, forVariable(variable), INITS);
    }

    public QMessageTag(Path<? extends MessageTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMessageTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMessageTag(PathMetadata metadata, PathInits inits) {
        this(MessageTag.class, metadata, inits);
    }

    public QMessageTag(Class<? extends MessageTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.message = inits.isInitialized("message") ? new QMessage(forProperty("message"), inits.get("message")) : null;
        this.messageTemplate = inits.isInitialized("messageTemplate") ? new QMessageTemplate(forProperty("messageTemplate")) : null;
    }

}

