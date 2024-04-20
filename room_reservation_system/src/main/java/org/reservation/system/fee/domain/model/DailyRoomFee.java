package org.reservation.system.fee.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;
import org.reservation.system.fee.application.dto.PricingHistoryDTO;
import org.reservation.system.fee.value.MoneyInfo;
import org.reservation.system.reservation.domain.model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "T_DLY_ROOM_FEE", indexes = {
        @Index(name = "idx_dly_fee_id", columnList = "dly_fee_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "dly_fee_id"))
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "dailyRoomFee")
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
        if (pricingHistory.getDailyRoomFee() != this) {
            pricingHistory.setDailyRoomFee(this);
        }
    }

    public void removePricingHistory(PricingHistory pricingHistory) {
        if (pricingHistoryList != null && pricingHistoryList.remove(pricingHistory)) {
            if (pricingHistory.getDailyRoomFee() == this) {
                pricingHistory.setDailyRoomFee(null);
            }
        }
    }

    public DailyRoomFeeDTO entityToDTO(DailyRoomFee dailyRoomFee) {
        MoneyInfo moneyInfo = this.getMoneyInfo();

        List<PricingHistoryDTO> pricingHistoryDTOs = dailyRoomFee.pricingHistoryList != null ? dailyRoomFee.pricingHistoryList.stream()
                .map(pricingHistory -> new PricingHistoryDTO(
                        pricingHistory.getApplyReason(),
                        pricingHistory.getPricingType().toString(),
                        pricingHistory.getAppliedPrice()
                )).toList() : Collections.emptyList();


        return DailyRoomFeeDTO
                .builder()
                .feeName(dailyRoomFee.getFee().getFeeName())
                .addedAmount(moneyInfo.getAddedAmount())
                .productAmount(moneyInfo.getProductAmount())
                .discountAmount(moneyInfo.getDiscountAmount())
                .salesAmount(moneyInfo.getSalesAmount())
                .closeTime(dailyRoomFee.getCloseTime())
                .pricingHistoryDTOList(pricingHistoryDTOs)
                .occurDate(dailyRoomFee.getOccurDate())
                .build();
    }

}
