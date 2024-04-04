package org.reservation.system.fee.infrastructure.persistence;

import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.domain.model.Fee;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface QueryFeeRepository {
    List<Fee> findFeeWithComplexConditions(Pageable pageable, FeeSearchDTO feeSearchDTO);

    long feeCountWithComplexConditions(FeeSearchDTO feeSearchDTO);

    Fee findOneFeeWithConditions(FeeSearchDTO feeSearchDTO);

}