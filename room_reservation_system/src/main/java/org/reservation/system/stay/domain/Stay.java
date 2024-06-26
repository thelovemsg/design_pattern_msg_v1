package org.reservation.system.stay.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;
import org.reservation.system.stay.domain.other.RoomStay;

import java.util.List;

@Entity
@Getter
@Table(name = "T_STAY", indexes = {
        @Index(name = "idx_stay_id", columnList = "stay_id")
})
@AttributeOverride(name = "id", column = @Column(name = "stay_id"))
public class Stay extends BaseEntity {

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "rsvr_id")
    private Reservation reservation;

    @Embedded
    private ReservationInfo reservationInfo;

    private String checkinDivCd;

    @OneToMany(mappedBy = "stay")
    private List<StayHistory> stayHistoryList;

    @OneToMany(mappedBy = "stay")
    private List<RoomStay> roomStayList;

}
