package org.reservation.system.fee.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.room.domain.model.RoomType;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "T_FEE", indexes = {
        @Index(name = "idx_fee_id", columnList = "fee_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "fee_id"))
public class Fee extends BaseEntity {
    private String feeName;
    private Boolean isUsed;
    private String remark;
    private BigDecimal feeAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @OneToMany(mappedBy = "fee")
    private List<DailyRoomFee> dailyRoomFeeList;
}
