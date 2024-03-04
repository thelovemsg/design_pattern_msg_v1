package org.reservation.system.room.enums;

public enum RoomStatusEnum {
    ROOM_VACANT("ROOM_VACANT"), ROOM_FIXING("ROOM_FIXING"), ROOM_OCCUPIED("ROOM_OCCUPIED"),
    ROOM_CLEANING("ROOM_CLEANING"), ROOM_ASSIGNED("ROOM_ASSIGNED"), ROOM_CLOSED("ROOM_CLOSED"),
    ROOM_BREAK_DOWN("ROOM_BREAK_DOWN");

    private String roomStatus;

    RoomStatusEnum(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
