package org.reservation.system.room.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.vo.RoomReservationQuery;
import org.reservation.system.room.application.vo.RoomBlockVO;
import org.reservation.system.room.application.vo.RoomVO;
import org.reservation.system.room.domain.repository.RoomRepository;
import org.reservation.system.room.domain.service.RoomDomainService;
import org.reservation.system.room.infrastructure.persistence.QueryRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomDomainServiceImpl implements RoomDomainService {

    private final RoomRepository roomRepository;
    private final QueryRoomRepository queryRoomRepository;

    @Override
    public List<RoomVO> findRoomIsReserved(RoomReservationQuery roomReservationQuery) {
        return queryRoomRepository.findAnyReservedRoomByReservationInfo(roomReservationQuery);
    }

    @Override
    public RoomBlockVO findRoomIsBlocked(RoomReservationQuery roomReservationQuery) {
        return queryRoomRepository.findBlockRoomInfoByReservationInfo(roomReservationQuery);
    }
}
