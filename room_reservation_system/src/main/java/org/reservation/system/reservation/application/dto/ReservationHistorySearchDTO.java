package org.reservation.system.reservation.application.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationHistorySearchDTO {
    private LocalDate leaveRoomDate;
    private LocalDate enterRoomDate;
}
