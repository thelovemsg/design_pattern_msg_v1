package org.reservation.system.reservation.enums;

public enum FeeApplyCdEnum {
    BASIC("BASIC"), OVER("OVER");

    private String applyCd;

    FeeApplyCdEnum(String applyCd) {
        this.applyCd = applyCd;
    }
}
