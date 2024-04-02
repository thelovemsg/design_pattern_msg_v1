package org.reservation.system.reservation.application.vo;

import java.time.LocalDate;

public record RoomReservationQuery(int roomNo, LocalDate enterRoomDate, int stayDayCnt) {
}
