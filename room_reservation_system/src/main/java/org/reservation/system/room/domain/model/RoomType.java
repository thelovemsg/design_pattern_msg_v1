package org.reservation.system.room.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.domain.model.Fee;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_ROOM_TYPE", indexes = {
        @Index(name = "idx_room_type_id", columnList = "room_type_id")
})
@AttributeOverride(name = "id", column = @Column(name = "room_type_id"))
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class RoomType extends BaseEntity {

    private String roomTypeCd;

    @OneToMany(mappedBy = "roomType")
    private List<Room> roomList;

    @OneToMany(mappedBy = "roomType")
    private List<Fee> feeList;

    public RoomType(String roomTypeCd) {
        super();
        this.roomTypeCd = roomTypeCd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType1 = (RoomType) o;
        return Objects.equals(roomTypeCd, roomType1.roomTypeCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomTypeCd, roomList, feeList);
    }
}
