package org.reservation.system.reservation.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReservationHistory is a Querydsl query type for ReservationHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReservationHistory extends EntityPathBase<ReservationHistory> {

    private static final long serialVersionUID = 1057173090L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReservationHistory reservationHistory = new QReservationHistory("reservationHistory");

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

    public final QReservation reservation;

    public QReservationHistory(String variable) {
        this(ReservationHistory.class, forVariable(variable), INITS);
    }

    public QReservationHistory(Path<? extends ReservationHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReservationHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReservationHistory(PathMetadata metadata, PathInits inits) {
        this(ReservationHistory.class, metadata, inits);
    }

    public QReservationHistory(Class<? extends ReservationHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reservation = inits.isInitialized("reservation") ? new QReservation(forProperty("reservation"), inits.get("reservation")) : null;
    }

}

