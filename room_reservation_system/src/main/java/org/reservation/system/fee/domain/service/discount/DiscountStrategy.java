package org.reservation.system.fee.domain.service.discount;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal applyDiscount(BigDecimal originalPrice, double discountRate);
    BigDecimal applyDiscount(BigDecimal price);
}
