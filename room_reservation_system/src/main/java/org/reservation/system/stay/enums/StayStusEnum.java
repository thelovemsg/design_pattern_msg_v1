package org.reservation.system.stay.enums;

public enum StayStusEnum {
    CHECKOUT_EXPECTED("CHCKOUT_EXPECTED"), CHECKIN("CHECKIN"), CHECKOUT("CHECKOUT");

    private String status;

    StayStusEnum(String status) {
        this.status = status;
    }
}
