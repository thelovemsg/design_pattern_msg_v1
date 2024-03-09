package org.reservation.system.fee.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.calander.domain.Calender;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.enums.CurnCdEnum;
import org.reservation.system.fee.value.Money;
import org.reservation.system.reservation.domain.Reservation;

import java.time.LocalTime;

@Entity
@Table(name = "T_DLY_FEE")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "dly_fee_id"))
public class DailyFee extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rsvr_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_id")
    private Fee fee;

    @Enumerated(EnumType.STRING)
    private CurnCdEnum currentCode;
    private LocalTime closeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clnd_id")
    private Calender calender;

    @Embedded
    private Money money;

}