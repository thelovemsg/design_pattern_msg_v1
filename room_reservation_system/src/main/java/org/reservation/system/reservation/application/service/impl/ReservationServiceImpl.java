package org.reservation.system.reservation.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.service.ReservationService;
import org.reservation.system.reservation.domain.repository.ReservationRepository;
import org.reservation.system.reservation.infrastructure.persistence.QueryReservationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final QueryReservationRepository queryReservationRepository;

}
