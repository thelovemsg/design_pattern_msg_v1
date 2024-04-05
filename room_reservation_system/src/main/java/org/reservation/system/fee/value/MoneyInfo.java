package org.reservation.system.fee.value;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoneyInfo {
    @Builder.Default
    private BigDecimal productAmount = new BigDecimal("0");
    @Builder.Default
    private BigDecimal addedAmount = new BigDecimal("0");
    @Builder.Default
    private BigDecimal discountAmount = new BigDecimal("0");
    @Builder.Default
    private BigDecimal salesAmount = new BigDecimal("0");
    @Builder.Default
    private BigDecimal taxAmount = new BigDecimal("0");

    // 더하기
    public BigDecimal addAmount(BigDecimal addingAmount) {
        productAmount = productAmount.add(addingAmount);
        addedAmount = addedAmount.add(addingAmount);
        BigDecimal tempSalesAmount = productAmount.subtract(discountAmount);
        salesAmount = tempSalesAmount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : tempSalesAmount;
        taxAmount = salesAmount.add(addingAmount).multiply(new BigDecimal("0.1")).setScale(0, RoundingMode.DOWN);
        return addingAmount;
    }

    // 빼기
    public BigDecimal subtractAmount(BigDecimal discountingAmount) {
        productAmount = productAmount.subtract(discountingAmount);
        discountAmount = discountAmount.add(discountingAmount);
        BigDecimal tempSalesAmount = productAmount.subtract(this.discountAmount);
        salesAmount = tempSalesAmount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : tempSalesAmount;
        taxAmount = salesAmount.subtract(discountingAmount).multiply(new BigDecimal("0.1")).setScale(0, RoundingMode.DOWN);
        return discountingAmount;
    }

    public BigDecimal calculateAmountByPercent(String addingRate) {
        BigDecimal rate = new BigDecimal(addingRate);
        BigDecimal originalProductAmount = productAmount;
        productAmount = originalProductAmount.multiply(rate).setScale(0, RoundingMode.DOWN);

        BigDecimal newAddedAmount = productAmount.subtract(originalProductAmount);
        addedAmount = addedAmount.add(newAddedAmount);

        BigDecimal tempSalesAmount = productAmount.subtract(discountAmount);
        salesAmount = tempSalesAmount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : tempSalesAmount;

        taxAmount = salesAmount.multiply(new BigDecimal("0.1")).setScale(0, RoundingMode.DOWN);

        return newAddedAmount;
    }
}
