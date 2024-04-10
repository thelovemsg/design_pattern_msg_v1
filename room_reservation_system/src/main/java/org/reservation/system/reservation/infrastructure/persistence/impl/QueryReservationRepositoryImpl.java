package org.reservation.system.reservation.infrastructure.persistence.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.infrastructure.persistence.QueryReservationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.reservation.system.reservation.domain.model.QReservation.reservation;

@Repository
@RequiredArgsConstructor
public class QueryReservationRepositoryImpl implements QueryReservationRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Reservation> findReservationWithComplexConditions(Pageable pageable, ReservationSearchDTO reservationSearchDTO) {
        return jpaQueryFactory.selectFrom(reservation)
                .where(enterAndLeaveDateBetween(reservationSearchDTO.getEnterRoomDate(), reservationSearchDTO.getLeaveRoomDate()),
                        containsGstNm(reservationSearchDTO.getGuestName()),
                        gstTelNoEq(reservationSearchDTO.getGuestTelno()),
                        salsAmountBetween(reservationSearchDTO.getMinSalesAmount(), reservationSearchDTO.getMaxSalesAmount()),
                        vipDivCdEq(reservationSearchDTO.getVipDivCd()),
                        couponCdEq(reservationSearchDTO.getCouponCode()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public long countReservationWithComplexConditions(ReservationSearchDTO reservationSearchDTO) {
        return jpaQueryFactory.selectFrom(reservation)
                .where(enterAndLeaveDateBetween(reservationSearchDTO.getEnterRoomDate(), reservationSearchDTO.getLeaveRoomDate()),
                        containsGstNm(reservationSearchDTO.getGuestName()),
                        gstTelNoEq(reservationSearchDTO.getGuestTelno()),
                        salsAmountBetween(reservationSearchDTO.getMinSalesAmount(), reservationSearchDTO.getMaxSalesAmount()),
                        vipDivCdEq(reservationSearchDTO.getVipDivCd()),
                        couponCdEq(reservationSearchDTO.getCouponCode()))
                .fetch().stream().count();
    }

    private BooleanExpression enterAndLeaveDateBetween(LocalDate enterRoomDate, LocalDate leaveRoomDate) {
        if (enterRoomDate == null && leaveRoomDate == null)
            return null;
        if (enterRoomDate == null && leaveRoomDate != null)
            return reservation.reservationInfo.leaveRoomDate.loe(leaveRoomDate);
        if (enterRoomDate != null && leaveRoomDate == null)
            return reservation.reservationInfo.enterRoomDate.goe(enterRoomDate);
        return reservation.reservationInfo.enterRoomDate.goe(enterRoomDate)
                .and(reservation.reservationInfo.leaveRoomDate.loe(leaveRoomDate));
    }

    private BooleanExpression containsGstNm(String gstNm) {
        if (StringUtils.isEmpty(gstNm))
            return null;

        return reservation.reservationInfo.guestName.stringValue().containsIgnoreCase(gstNm);
    }

    private BooleanExpression gstTelNoEq(String gstTelno) {
        if (StringUtils.isEmpty(gstTelno))
            return null;
        return reservation.reservationInfo.guestTelno.stringValue().eq(gstTelno);
    }

    private BooleanExpression salsAmountBetween(BigDecimal minSalsAmount, BigDecimal maxSalsAmount) {
        if (minSalsAmount == null && maxSalsAmount == null)
            return null;
        if (minSalsAmount == null && maxSalsAmount != null)
            return reservation.reservationInfo.salesAmount.loe(maxSalsAmount);
        if (minSalsAmount != null && maxSalsAmount == null)
            return reservation.reservationInfo.salesAmount.goe(minSalsAmount);
        return reservation.reservationInfo.salesAmount.between(minSalsAmount, maxSalsAmount);
    }

    private BooleanExpression vipDivCdEq(String vipDivCd) {
        if (StringUtils.isEmpty(vipDivCd))
            return null;
        return reservation.reservationInfo.vipDivCd.eq(vipDivCd);
    }

    private BooleanExpression couponCdEq(String couponCd) {
        if (StringUtils.isEmpty(couponCd))
            return null;
        return reservation.reservationInfo.couponCode.eq(couponCd);
    }

}