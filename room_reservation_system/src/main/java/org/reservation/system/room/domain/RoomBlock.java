package org.reservation.system.room.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.time.ZonedDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "T_ROOM_BLOCK")
@Getter
public class RoomBlock extends BaseEntity {

    private String roomBlockType;
    private ZonedDateTime blockStartDate;
    private ZonedDateTime blockEndDate;
    private ZonedDateTime blockEndPlanDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id")
    private Room room;
}
