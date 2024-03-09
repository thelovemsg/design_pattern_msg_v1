package org.reservation.system.customer.domain;

public enum CustDivCdEnum {
    VIP("VIP"), STANDARD("STD"), SILVER("SILVER"), GOLD("GOLD");

    private String level;

    CustDivCdEnum(String level) {
        this.level = level;
    }
}
