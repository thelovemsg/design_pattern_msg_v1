package org.reservation.system.reservation.domain.service;

import org.reservation.system.reservation.application.dto.ReservationCreationDTO;

public interface ReservationDomainService {
    void checkIfReservationPossible(ReservationCreationDTO creationDTO);
    ReservationCreationDTO makeReservationInfo(ReservationCreationDTO reservationCreationDTO);

}
