package org.reservation.system.fee.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.application.dto.PricingHistoryDTO;
import org.reservation.system.fee.application.enums.ChargeEnum;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "T_DSC_FEE", indexes = {
        @Index(name = "idx_dsc_fee_id", columnList = "dsc_fee_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "dsc_fee_id"))
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PricingHistory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tmp_dly_fee_id")
    private TempDailyFee tempDailyFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dly_room_fee_id")
    private DailyRoomFee dailyRoomFee;

    private String applyReason; // 예: "기간 할인", "비수기 할인", "쿠폰 할인"
    @Enumerated(EnumType.STRING)
    private ChargeEnum pricingType;

    private BigDecimal appliedPrice;

}
