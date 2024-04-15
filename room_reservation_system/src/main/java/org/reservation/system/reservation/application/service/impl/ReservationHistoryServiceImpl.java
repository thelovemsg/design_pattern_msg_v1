package org.reservation.system.reservation.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationHistoryDTO;
import org.reservation.system.reservation.application.dto.ReservationHistorySearchDTO;
import org.reservation.system.reservation.application.service.ReservationHistoryService;
import org.reservation.system.reservation.domain.model.ReservationHistory;
import org.reservation.system.reservation.domain.repository.ReservationHistoryRepository;
import org.reservation.system.reservation.infrastructure.persistence.QueryReservationHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationHistoryServiceImpl implements ReservationHistoryService {

    private final ReservationHistoryRepository reservationHistoryRepository;
    private final QueryReservationHistoryRepository queryReservationHistoryRepository;

    @Override
    public Page<ReservationHistoryDTO> selectReservationHistoryList(Pageable pageable, ReservationHistorySearchDTO reservationHistorySearchDTO) {
        List<ReservationHistory> withComplexConditions = queryReservationHistoryRepository.findWithComplexConditions(pageable, reservationHistorySearchDTO);
        return null;
    }
}
