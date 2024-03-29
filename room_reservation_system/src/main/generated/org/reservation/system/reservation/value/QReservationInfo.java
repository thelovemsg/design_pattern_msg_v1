package org.reservation.system.reservation.value;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;


/**
 * QReservationInfo is a Querydsl query type for ReservationInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QReservationInfo extends BeanPath<ReservationInfo> {

    private static final long serialVersionUID = -761367544L;

    public static final QReservationInfo reservationInfo = new QReservationInfo("reservationInfo");

    public final StringPath couponCode = createString("couponCode");

    public final NumberPath<java.math.BigDecimal> discountAmount = createNumber("discountAmount", java.math.BigDecimal.class);

    public final DatePath<java.time.LocalDate> enterRoomDate = createDate("enterRoomDate", java.time.LocalDate.class);

    public final StringPath guestName = createString("guestName");

    public final StringPath guestTelno = createString("guestTelno");

    public final DatePath<java.time.LocalDate> leaveRoomDate = createDate("leaveRoomDate", java.time.LocalDate.class);

    public final NumberPath<java.math.BigDecimal> productAmount = createNumber("productAmount", java.math.BigDecimal.class);

    public final StringPath reserverName = createString("reserverName");

    public final StringPath reserverTelno = createString("reserverTelno");

    public final NumberPath<java.math.BigDecimal> salesAmount = createNumber("salesAmount", java.math.BigDecimal.class);

    public final NumberPath<Integer> stayDayCnt = createNumber("stayDayCnt", Integer.class);

    public final StringPath stayStatus = createString("stayStatus");

    public final NumberPath<java.math.BigDecimal> taxAmount = createNumber("taxAmount", java.math.BigDecimal.class);

    public final StringPath vipDivCd = createString("vipDivCd");

    public QReservationInfo(String variable) {
        super(ReservationInfo.class, forVariable(variable));
    }

    public QReservationInfo(Path<? extends ReservationInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservationInfo(PathMetadata metadata) {
        super(ReservationInfo.class, metadata);
    }

}

