package org.reservation.system.fee.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.value.MoneyInfo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "T_TMP_DLY_ROOM_FEE", indexes = {
        @Index(name = "idx_tmp_dly_fee_id", columnList = "tmp_dly_fee_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "tmp_dly_fee_id"))
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TempDailyFee extends BaseEntity {

    private LocalDate occurDate;
    private LocalTime occurTime;

    private String feeName;
    private String roomTypeCd;

    @OneToMany(mappedBy = "tempDailyFee")
    private List<PricingHistory> pricingHistoryList;

    @Embedded
    private MoneyInfo moneyInfo;

}
