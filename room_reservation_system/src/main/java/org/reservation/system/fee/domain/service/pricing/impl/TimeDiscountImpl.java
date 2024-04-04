package org.reservation.system.fee.domain.service.pricing.impl;

import org.reservation.system.fee.domain.service.pricing.DiscountStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TimeDiscountImpl implements DiscountStrategy {
    @Override
    public BigDecimal applyDiscount(BigDecimal originalPrice, double discountRate) {
        return null;
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal price) {
        return null;
    }
}
