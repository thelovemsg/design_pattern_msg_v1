package org.reservation.system.reservation.value;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import org.reservation.system.reservation.enums.FeeApplyCdEnum;
import org.reservation.system.stay.enums.StayStusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@Getter
public class ReservationInfo {
    private String guestName;
    private String guestTelno;
    private StayStusEnum stayStatus;
    private Integer stayDayCnt;
    private String reserverName;
    private String reserverTelno;
    private LocalDate enterRoomDate;
    private LocalDate leaveRoomDate;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private FeeApplyCdEnum feeApplyCd;
}
