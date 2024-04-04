package org.reservation.system.calander.application.service.enums;

import lombok.Getter;

@Getter
public enum DayDivEnum {
    SUN("1"), MON("2"), THU("3"), WEN("4"), THR("5"), FRI("6"), SAT("7");

    private final String dayCode;

    DayDivEnum(String dayCode) {
        this.dayCode = dayCode;
    }

    public static boolean isPeakOfWeek(String dayCode) {
        return dayCode.equals("5") || dayCode.equals("6");
    }

}
