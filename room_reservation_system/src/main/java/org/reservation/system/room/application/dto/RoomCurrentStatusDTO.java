package org.reservation.system.room.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.room.domain.model.RoomType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomCurrentStatusDTO {
    private LocalDate baseDate;
    private Long reservationCount;
    private Long roomTotalCount;
    private List<RoomTypeResponseDTO> roomTypeResponseList = new ArrayList<>();

    public RoomCurrentStatusDTO(LocalDate baseDate) {
        this.baseDate = baseDate;
    }

    public void addRoomTotalCount(String roomTypeCd, Long count) {
        roomTypeResponseList.add(new RoomTypeResponseDTO(roomTypeCd, count));
        this.roomTotalCount += count;
    }
}
