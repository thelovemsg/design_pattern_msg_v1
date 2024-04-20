package org.reservation.system.fee.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.value.MoneyInfo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_id")
    private Fee fee;

    @OneToMany(mappedBy = "tempDailyFee")
    private List<PricingHistory> pricingHistoryList;

    @Embedded
    private MoneyInfo moneyInfo;

    public void changeMoneyInfo(MoneyInfo moneyInfo) {
        this.moneyInfo = moneyInfo;
    }

    public void addPricingHistory(PricingHistory pricingHistory) {
        if (pricingHistoryList == null) {
            pricingHistoryList = new ArrayList<>();
        }
        pricingHistoryList.add(pricingHistory);
        if (pricingHistory.getTempDailyFee() != this) {
            pricingHistory.setTempDailyFee(this);
        }
    }

    public void removePricingHistory(PricingHistory pricingHistory) {
        if (pricingHistoryList != null && pricingHistoryList.remove(pricingHistory)) {
            if (pricingHistory.getTempDailyFee() == this) {
                pricingHistory.setTempDailyFee(null);
            }
        }
    }

}
