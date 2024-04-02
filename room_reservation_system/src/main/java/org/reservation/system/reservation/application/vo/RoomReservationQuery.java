package org.reservation.system.reservation.application.vo;

import java.time.LocalDate;

public record RoomReservationQuery(Long roomId, LocalDate enterRoomDate, int stayDayCnt) {
}
