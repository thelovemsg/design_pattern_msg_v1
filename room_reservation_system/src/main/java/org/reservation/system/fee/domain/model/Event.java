package org.reservation.system.fee.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.application.enums.ChargeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "T_EVENT", indexes = {
        @Index(name = "idx_event_id", columnList = "event_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "event_id"))
public class Event extends BaseEntity {

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private ChargeEnum chargeDivCd;

    @DecimalMin(value = "0.00")
    private BigDecimal chargeAmount;
}
