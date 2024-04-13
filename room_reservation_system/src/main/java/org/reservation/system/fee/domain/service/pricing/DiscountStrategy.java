package org.reservation.system.fee.domain.service.pricing;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal applyDiscount(BigDecimal originalPrice, double discountRate);
    BigDecimal applyDiscount(BigDecimal price);
}
