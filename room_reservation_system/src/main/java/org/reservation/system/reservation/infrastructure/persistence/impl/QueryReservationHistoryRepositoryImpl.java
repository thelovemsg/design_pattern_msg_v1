package org.reservation.system.reservation.infrastructure.persistence.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationHistorySearchDTO;
import org.reservation.system.reservation.domain.model.ReservationHistory;
import org.reservation.system.reservation.infrastructure.persistence.QueryReservationHistoryRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static org.reservation.system.reservation.domain.model.QReservationHistory.*;

@Repository
@RequiredArgsConstructor
public class QueryReservationHistoryRepositoryImpl implements QueryReservationHistoryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ReservationHistory> findWithComplexConditions(Pageable pageable, ReservationHistorySearchDTO reservationHistorySearchDTO) {
        jpaQueryFactory.select()
                .from(reservationHistory)
                .where(reservationHistory.deleted.eq(FALSE)
                        .and(reservationHistory.))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return null;
    }
}
