package org.reservation.system.room.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.domain.model.Fee;

import java.util.List;

@Entity
@Table(name = "T_ROOM_TYPE")
@AttributeOverride(name = "id", column = @Column(name = "room_type_id"))
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class RoomType extends BaseEntity {

    private String roomType;

    @OneToMany(mappedBy = "roomType")
    private List<Room> roomList;

    @OneToMany(mappedBy = "roomType")
    private List<Fee> feeList;
}
