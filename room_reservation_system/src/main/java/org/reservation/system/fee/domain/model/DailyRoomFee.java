package org.reservation.system.fee.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.value.Money;
import org.reservation.system.reservation.domain.model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "T_DLY_ROOM_FEE")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "dly_fee_id"))
public class DailyRoomFee extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rsvr_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_id")
    private Fee fee;

    private LocalDate occurDate;
    private String currentCode;
    private LocalTime closeTime;


    @Embedded
    private Money money;

}
