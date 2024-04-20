package org.reservation.system.fee.application.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeCreateVO {
    Integer roomNo;
    Integer custNo;
    String roomTypeCd;
    Integer stayDayCnt;
    LocalDate enterRoomDate;
    Long reservationId;
}
