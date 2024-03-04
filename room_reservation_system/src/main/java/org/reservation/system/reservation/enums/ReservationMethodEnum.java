package org.reservation.system.reservation.enums;

public enum ReservationMethodEnum {
    TEL("TEL"), WORK_IN("WORK_IN"), INTERNET("INTERNET");
    private String method;

    ReservationMethodEnum(String method) {
        this.method = method;
    }
}
