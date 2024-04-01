package org.reservation.system.reservation.application.service;

import org.reservation.system.reservation.application.dto.ReservationCreationDTO;

public interface ReservationService {
    ReservationCreationDTO makeRoomReservation(ReservationCreationDTO ReservationCreationDTO);
}
