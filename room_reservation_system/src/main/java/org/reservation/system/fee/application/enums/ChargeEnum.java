package org.reservation.system.fee.application.enums;

import lombok.Getter;

@Getter
public enum ChargeEnum {
    CHARGE, DISCOUNT;

    public static boolean isAddingPrice(ChargeEnum chargeDivCd) {
        return chargeDivCd == ChargeEnum.CHARGE;
    }
}
