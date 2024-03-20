package org.reservation.system.message.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessageTemplate is a Querydsl query type for MessageTemplate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessageTemplate extends EntityPathBase<MessageTemplate> {

    private static final long serialVersionUID = 1148504209L;

    public static final QMessageTemplate messageTemplate = new QMessageTemplate("messageTemplate");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

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

    public final ListPath<MessageTag, QMessageTag> messageTagList = this.<MessageTag, QMessageTag>createList("messageTagList", MessageTag.class, QMessageTag.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final StringPath name = createString("name");

    public final StringPath templateType = createString("templateType");

    public final StringPath variant1 = createString("variant1");

    public final StringPath variant2 = createString("variant2");

    public final StringPath variant3 = createString("variant3");

    public final StringPath variant4 = createString("variant4");

    public final StringPath variant5 = createString("variant5");

    public final StringPath variant6 = createString("variant6");

    public final StringPath variant7 = createString("variant7");

    public final StringPath variant8 = createString("variant8");

    public QMessageTemplate(String variable) {
        super(MessageTemplate.class, forVariable(variable));
    }

    public QMessageTemplate(Path<? extends MessageTemplate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMessageTemplate(PathMetadata metadata) {
        super(MessageTemplate.class, metadata);
    }

}

