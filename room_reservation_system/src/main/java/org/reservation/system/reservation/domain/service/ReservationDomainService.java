package org.reservation.system.reservation.domain.service;

import org.reservation.system.reservation.application.dto.ReservationCreationDTO;

public interface ReservationDomainService {
    ReservationCreationDTO makeReservationInfo(ReservationCreationDTO reservationCreationDTO);
}
