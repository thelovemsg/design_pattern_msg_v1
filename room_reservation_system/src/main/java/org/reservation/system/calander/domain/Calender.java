package org.reservation.system.calander.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.calander.enums.DayDivCdEnum;
import org.reservation.system.calander.enums.OperationDivCdEnum;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.domain.DailyFee;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Table(name = "T_CLND")
@AttributeOverride(name = "id", column = @Column(name = "clnd_id"))
public class Calender extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private DayDivCdEnum dayDivCd;

    @Enumerated(EnumType.STRING)
    private OperationDivCdEnum operationDivCd;

    private LocalDate solarDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<DailyFee> dailyFeeList;
}
