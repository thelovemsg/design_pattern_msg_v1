package org.reservation.system.reservation.application.service;

import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.domain.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {
    ReservationCreationDTO makeRoomReservation(ReservationCreationDTO ReservationCreationDTO);
    Page<ReservationDTO> selectReservationList(Pageable pageable, ReservationSearchDTO reservationSearchDTO);
    ReservationDTO getReservationById(Long id);
    void updateReservation(Reservation reservation);
}
