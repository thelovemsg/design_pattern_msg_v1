package org.reservation.system.common.enums;

public enum ContentTypeEnum {
    JSON("application/json"),
    HTML("text/html"),
    TEXT("text/plain"),
    XML("application/xml");


    private final String contentType;

    ContentTypeEnum(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }
}
