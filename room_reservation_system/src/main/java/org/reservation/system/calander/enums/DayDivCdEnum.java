package org.reservation.system.calander.enums;

public enum DayDivCdEnum {
    SUNDAY("SUNDAY"), MONDAY("MONDAY"), THUESDAY("THUESDAY"), WEDNESDAY("WEDNESDAY")
    , THURSDAY("THURSDAY"), FRIDAY("FRIDAY"),SATURDAY("SATURDAY");

    private String day;

    DayDivCdEnum(String day) {
        this.day = day;
    }
}
