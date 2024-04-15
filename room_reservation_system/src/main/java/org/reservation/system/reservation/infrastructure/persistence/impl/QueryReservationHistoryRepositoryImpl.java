package org.reservation.system.reservation.infrastructure.persistence.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationHistorySearchDTO;
import org.reservation.system.reservation.domain.model.ReservationHistory;
import org.reservation.system.reservation.infrastructure.persistence.QueryReservationHistoryRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static org.reservation.system.reservation.domain.model.QReservation.reservation;
import static org.reservation.system.reservation.domain.model.QReservationHistory.reservationHistory;

@Repository
@RequiredArgsConstructor
public class QueryReservationHistoryRepositoryImpl implements QueryReservationHistoryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ReservationHistory> findWithComplexConditions(Pageable pageable, ReservationHistorySearchDTO reservationHistorySearchDTO) {
        return jpaQueryFactory.selectFrom(reservationHistory)
                .join(reservationHistory.reservation, reservation)
                .where(enterAndLeaveDateBetween(reservationHistorySearchDTO.getEnterRoomDate(), reservationHistorySearchDTO.getLeaveRoomDate())
                        .and(reservationHistory.deleted.eq(FALSE)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public long countReservationHistoryWithComplexConditions(ReservationHistorySearchDTO reservationHistorySearchDTO) {
        return jpaQueryFactory.selectFrom(reservationHistory)
                .join(reservationHistory.reservation, reservation)
                .where(enterAndLeaveDateBetween(reservationHistorySearchDTO.getEnterRoomDate(), reservationHistorySearchDTO.getLeaveRoomDate())
                        .and(reservationHistory.deleted.eq(FALSE)))
                .stream().count();
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

}
