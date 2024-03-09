package org.reservation.system.fee.value;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.math.BigDecimal;

@Embeddable
@Getter
public class Money {
    private BigDecimal productAmount;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private BigDecimal taxAmount;
    private String discountReason;

    // 더하기

    // 빼기

    // 세금계산

}
