package org.reservation.system.reservation.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationCreationDTO {
    private Long id;
    @NotNull
    private Integer roomNo;
    private Integer custNo;
    private Integer custNm;
    @NotEmpty
    private String feeName;
    @NotEmpty
    private String roomTypeCd;
    private String reservationMethod;
    @NotEmpty
    private String guestName;
    @NotEmpty
    private String guestTelno;
    private String stayStatus;
    @NotNull
    private Integer stayDayCnt;
    @NotEmpty
    private String reserverName;
    @NotEmpty
    private String reserverTelno;
    @NotEmpty
    private LocalDate enterRoomDate;
    @NotEmpty
    private LocalDate leaveRoomDate;
    private BigDecimal discountAmount;
    @NotNull
    private BigDecimal salesAmount;
    @NotNull
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private String vipDivCd;
    private String couponCode;

    private List<DailyRoomFeeDTO> dailyRoomFeeDTOS;

    public void setDailyRoomFeeDTOS(List<DailyRoomFeeDTO> dailyRoomFeeDTOS) {
        this.dailyRoomFeeDTOS = dailyRoomFeeDTOS;
    }
}
