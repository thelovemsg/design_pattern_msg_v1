package org.reservation.system.room.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomCurrentStatusDTO {
    private LocalDate baseDate;
    private Long roomReservationCount;
    private Long roomTotalCount;
    private Long possibleRoomCount;
    private String reservationRate;
    private List<RoomTypeResponseDTO> roomTypeResponseList = new ArrayList<>();

    public RoomCurrentStatusDTO(LocalDate baseDate) {
        this.baseDate = baseDate;
    }

    public void addRoomTotalCount(String roomTypeCd, Long count, Long id) {
        roomTypeResponseList.add(new RoomTypeResponseDTO(roomTypeCd, count, id));
        roomReservationCount += count;
    }

    public void calculateRoomReservationRate(Long roomCount) {
        roomTotalCount = roomCount;
        possibleRoomCount = roomTotalCount - roomReservationCount;
        reservationRate = Math.round(((double) roomTotalCount / roomReservationCount * 100) * 10) + "%";
    }
}
