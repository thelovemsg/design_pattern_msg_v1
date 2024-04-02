package org.reservation.system.room.domain.service;

import org.reservation.system.reservation.application.vo.RoomReservationQuery;
import org.reservation.system.room.application.vo.RoomVO;

import java.util.List;

public interface RoomDomainService {
    List<RoomVO> findAnyReservedRoom(RoomReservationQuery roomReservationQuery);
}
