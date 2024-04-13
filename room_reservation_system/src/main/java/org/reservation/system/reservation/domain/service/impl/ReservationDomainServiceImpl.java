package org.reservation.system.reservation.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.reservation.system.reservation.domain.repository.ReservationRepository;
import org.reservation.system.reservation.domain.service.ReservationDomainService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationDomainServiceImpl implements ReservationDomainService {

    private final ReservationRepository reservationRepository;

    @Override
    public void checkIfReservationPossible(ReservationCreationDTO creationDTO) {

    }

    @Override
    public ReservationCreationDTO makeReservationInfo(ReservationCreationDTO reservationCreationDTO) {
        //예약 정보 실제 저장
        return null;
    }
}
