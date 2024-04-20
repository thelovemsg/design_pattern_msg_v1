package org.reservation.system.reservation.domain.service;

import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.domain.model.Reservation;

public interface ReservationDomainService {
    Reservation makeReservationInfo(ReservationDTO reservationDTO);

}
