package org.reservation.system.fee.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "T_FEE")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "fee_id"))
public class Fee extends BaseEntity {
    private String feeName;
    private Boolean isUsed;
    private String remark;
    private BigDecimal feeAmount;

    private String basisCd;
    private String peakDivCd;

    @OneToMany(mappedBy = "fee")
    private List<RoomFee> roomFee;

    @OneToMany(mappedBy = "fee")
    private List<DailyFee> dailyFeeList;



}
