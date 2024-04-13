package org.reservation.system.calander.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCalender is a Querydsl query type for Calender
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCalender extends EntityPathBase<Calender> {

    private static final long serialVersionUID = -1273481665L;

    public static final QCalender calender = new QCalender("calender");

    public final org.reservation.system.common.entity.QBaseEntity _super = new org.reservation.system.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createDate = _super.createDate;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath dayDivCd = createString("dayDivCd");

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath holidayDivCd = createString("holidayDivCd");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifyDate = _super.modifyDate;

    public final StringPath name = createString("name");

    public final StringPath seasonDivCd = createString("seasonDivCd");

    public final DatePath<java.time.LocalDate> solarDate = createDate("solarDate", java.time.LocalDate.class);

    public QCalender(String variable) {
        super(Calender.class, forVariable(variable));
    }

    public QCalender(Path<? extends Calender> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCalender(PathMetadata metadata) {
        super(Calender.class, metadata);
    }

}

