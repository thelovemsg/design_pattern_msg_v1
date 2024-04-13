package org.reservation.system.reservation.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.fee.application.dto.DailyFeeDTO;
import org.reservation.system.fee.application.dto.FeeDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationCreationDTO {
    private Long roomId;
    private String guestName;
    private String guestTelno;
    private String stayStatus;
    private Integer roomNo;
    private String roomTypeCd;
    @NotBlank
    private Integer stayDayCnt;
    private String reserverName;
    @NotBlank
    private String reserverTelno;
    @NotBlank
    private LocalDate enterRoomDate;
    @NotBlank
    private LocalDate leaveRoomDate;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private String reservationMethod;
    private Integer custNo;
    private String vipDivCd;
    private String couponCode;

    private List<DailyFeeDTO> dailyFeeDTOS;

    public void setDailyFeeDTOS(List<DailyFeeDTO> dailyFeeDTOS) {
        this.dailyFeeDTOS = dailyFeeDTOS;
    }
}
