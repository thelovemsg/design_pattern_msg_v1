package org.reservation.system.common.enums;

import lombok.Getter;

@Getter
public enum LangEnum {
    KOKR("ko_KR"), ENUS("en_US");

    private String lang;

    LangEnum(String lang) {
        this.lang = lang;
    }
}