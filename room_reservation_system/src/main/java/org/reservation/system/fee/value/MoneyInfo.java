package org.reservation.system.fee.value;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
@Getter
@Builder(toBuilder = true)
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
    @Transient
    @Builder.Default
    private BigDecimal differentAmount = new BigDecimal("0");

    public MoneyInfo addAmount(BigDecimal addingAmount) {
        BigDecimal newProductAmount = this.productAmount.add(addingAmount);
        BigDecimal newAddedAmount = this.addedAmount.add(addingAmount);
        BigDecimal newSalesAmount = newProductAmount.subtract(discountAmount);
        newSalesAmount = newSalesAmount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : newSalesAmount;
        BigDecimal newTaxAmount = newSalesAmount.multiply(new BigDecimal("0.1")).setScale(0, RoundingMode.DOWN);

        return this.toBuilder()
                .productAmount(newProductAmount)
                .addedAmount(newAddedAmount)
                .differentAmount(addingAmount)
                .salesAmount(newSalesAmount)
                .taxAmount(newTaxAmount)
                .build();
    }

    public MoneyInfo subtractAmount(BigDecimal subtractingAmount) {
        BigDecimal newProductAmount = this.productAmount.subtract(subtractingAmount);
        BigDecimal newDiscountAmount = this.discountAmount.add(subtractingAmount);
        BigDecimal newSalesAmount = newProductAmount.subtract(newDiscountAmount);
        newSalesAmount = newSalesAmount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : newSalesAmount;
        BigDecimal newTaxAmount = newSalesAmount.multiply(new BigDecimal("0.1")).setScale(0, RoundingMode.DOWN);

        return this.toBuilder()
                .productAmount(newProductAmount)
                .discountAmount(newDiscountAmount)
                .salesAmount(newSalesAmount)
                .differentAmount(subtractingAmount)
                .taxAmount(newTaxAmount)
                .build();
    }

    public MoneyInfo calculateAmountByPercent(String addingRate) {
        BigDecimal rate = new BigDecimal(addingRate);
        differentAmount = productAmount.subtract(productAmount.multiply(rate)).setScale(0, RoundingMode.DOWN);

        BigDecimal newProductAmount = this.productAmount.multiply(rate).setScale(0, RoundingMode.DOWN);
        BigDecimal newAddedAmount = differentAmount;
        BigDecimal newSalesAmount = newProductAmount.subtract(this.discountAmount);
        newSalesAmount = newSalesAmount.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : newSalesAmount;
        BigDecimal newTaxAmount = newSalesAmount.multiply(new BigDecimal("0.1")).setScale(0, RoundingMode.DOWN);

        return this.toBuilder()
                .productAmount(newProductAmount)
                .addedAmount(this.addedAmount.add(newAddedAmount))
                .differentAmount(differentAmount)
                .salesAmount(newSalesAmount)
                .taxAmount(newTaxAmount)
                .build();
    }
}
