package org.reservation.system.stay.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.stay.enums.CheckinDivEnum;
import org.reservation.system.stay.enums.StayStusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
public class Stay extends BaseEntity {

    private String guestName;
    private String guestTelno;
    private StayStusEnum stayStatus;
    private Integer stayDayCnt;
    private String reserverName;
    private String reserverTelno;
    private LocalDate enterRoomDate;
    private LocalDate leaveRoomDate;
    private LocalDate checkInDate;
    private LocalTime checkInTime;
    private LocalTime checkOutDate;
    private LocalTime checkOutTime;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private BigDecimal productAmount;
    private BigDecimal taxAmount;

    @Enumerated(EnumType.STRING)
    private CheckinDivEnum checkinDivCd;

}
