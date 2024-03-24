package org.reservation.system.fee.infrastructure.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.fee.infrastructure.repository.QueryFeeRepository;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

import static org.reservation.system.fee.domain.model.QFee.fee;

@Repository
@RequiredArgsConstructor
public class QueryFeeRepositoryImpl implements QueryFeeRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final RoomTypeRepository roomTypeRepository;

    @Override
    public List<Fee> findFeeWithComplexConditions(Pageable pageable, FeeSearchDTO feeSearchDTO) {
        return jpaQueryFactory.selectFrom(fee)
                .where(containFeeName(feeSearchDTO.getFeeName()),
                        eqRoomType(feeSearchDTO.getRoomTypeCd()),
                        feeAmountBetween(feeSearchDTO.getMinFeeAmount(), feeSearchDTO.getMaxFeeAmount()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public long feeCountWithComplexConditions(FeeSearchDTO feeSearchDTO) {
        return jpaQueryFactory.selectFrom(fee)
                .where(containFeeName(feeSearchDTO.getFeeName()),
                        eqRoomType(feeSearchDTO.getRoomTypeCd()),
                        feeAmountBetween(feeSearchDTO.getMinFeeAmount(), feeSearchDTO.getMaxFeeAmount()))
                .fetch().stream().count();
    }

    private BooleanExpression containFeeName(String feeName) {
        if (StringUtils.isEmpty(feeName)) {
            return null;
        }

        return fee.feeName.stringValue().containsIgnoreCase(feeName);
    }

    private BooleanExpression eqRoomType(String roomTypeCd) {
        if (StringUtils.isEmpty(roomTypeCd)) {
            return null;
        }

        RoomType roomType = roomTypeRepository.findByRoomTypeCd(roomTypeCd).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + roomTypeCd));

        if (roomType == null) {
            return null;
        }

        return fee.roomType.eq(roomType);
    }

    private BooleanExpression feeAmountBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        if (minPrice == null && maxPrice == null) {
            return null;
        } else if (minPrice == null) {
            return fee.feeAmount.loe(maxPrice);
        } else if (maxPrice == null) {
            return fee.feeAmount.goe(minPrice);
        } else {
            return fee.feeAmount.between(minPrice, maxPrice);
        }
    }

}