package org.reservation.system.reservation.application.service;

import org.reservation.system.reservation.application.dto.ReservationHistoryDTO;
import org.reservation.system.reservation.application.dto.ReservationHistorySearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationHistoryService {
    Page<ReservationHistoryDTO> selectReservationHistoryList(Pageable pageable, ReservationHistorySearchDTO reservationHistorySearchDTO);
}
