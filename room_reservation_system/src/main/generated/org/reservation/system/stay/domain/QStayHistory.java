package org.reservation.system.stay.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStayHistory is a Querydsl query type for StayHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStayHistory extends EntityPathBase<StayHistory> {

    private static final long serialVersionUID = 195600467L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStayHistory stayHistory = new QStayHistory("stayHistory");

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

    public final QStay stay;

    public QStayHistory(String variable) {
        this(StayHistory.class, forVariable(variable), INITS);
    }

    public QStayHistory(Path<? extends StayHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStayHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStayHistory(PathMetadata metadata, PathInits inits) {
        this(StayHistory.class, metadata, inits);
    }

    public QStayHistory(Class<? extends StayHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stay = inits.isInitialized("stay") ? new QStay(forProperty("stay"), inits.get("stay")) : null;
    }

}

