package org.reservation.system.stay.enums;

public enum CheckinDivEnum {
    CHECKIN("CHECKIN"), CHECKOUT("CHECKOUT");

    private String checkingDivCd;

    CheckinDivEnum(String checkingDivCd) {
        this.checkingDivCd = checkingDivCd;
    }
}
