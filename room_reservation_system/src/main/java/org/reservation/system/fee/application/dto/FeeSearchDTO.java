package org.reservation.system.fee.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class FeeSearchDTO {
    private String feeName;
    private String custNo;
    private Integer roomNo;
    private Integer stayDayCnt;
    private LocalDate enterRoomDate;

    private BigDecimal minFeeAmount;
    private BigDecimal maxFeeAmount;
    private String roomTypeCd;
    private String remark;

}
