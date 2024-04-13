package org.reservation.system.room.application.vo;

import java.time.ZonedDateTime;

public record RoomBlockVO(
          Integer roomNo
        , String roomBlockType
        , ZonedDateTime blockStartDate
        , ZonedDateTime blockEndDate
        , ZonedDateTime blockEndPlanDate
        , String remark) {
}
