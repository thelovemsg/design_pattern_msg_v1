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
    private BigDecimal minFeeAmount;
    private BigDecimal maxFeeAmount;
    private String currentCode;

    private Integer stayDayCnt;
    private LocalDate enterRoomDate;
    private Integer roomNo;
    private String roomTypeCd;
    private String remark;

}
