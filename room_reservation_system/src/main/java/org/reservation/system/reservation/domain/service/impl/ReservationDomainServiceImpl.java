package org.reservation.system.reservation.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.repository.ReservationRepository;
import org.reservation.system.reservation.domain.service.ReservationDomainService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationDomainServiceImpl implements ReservationDomainService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation makeReservationInfo(ReservationDTO reservationDTO) {
        return reservationRepository.save(ReservationDTO.dtoToEntity(reservationDTO));
    }
}
