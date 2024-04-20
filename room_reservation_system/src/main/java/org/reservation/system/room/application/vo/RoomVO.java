package org.reservation.system.room.application.vo;


import groovy.lang.GrabExclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomVO {
    private Integer roomNo;
    private String roomName;
    private String roomType;
}
