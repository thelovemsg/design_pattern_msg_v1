package org.reservation.system.fee.value;

import groovy.transform.AnnotationCollector;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Money {
    private BigDecimal productAmount = new BigDecimal("0");
    private BigDecimal discountAmount = new BigDecimal("0");
    private BigDecimal salesAmount = new BigDecimal("0");
    private BigDecimal taxAmount = new BigDecimal("0");

    // 더하기

    // 빼기

    // 세금계산

}
