package org.reservation.system.fee.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.dto.FeeResponseDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.service.FeeService;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.fee.domain.repository.FeeRepository;
import org.reservation.system.fee.infrastructure.persistence.QueryFeeRepository;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {

    private final FeeRepository feeRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final QueryFeeRepository queryFeeRepository;
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");

    @Override
    public Page<FeeResponseDTO> selectFeeList(Pageable pageable, FeeSearchDTO feeSearchDTO) {
        List<Fee> feeWithComplexConditions = queryFeeRepository.findFeeWithComplexConditions(pageable, feeSearchDTO);
        List<FeeResponseDTO> feeResponseDTOList = feeWithComplexConditions.stream().map(fee -> FeeResponseDTO.builder()
                .id(fee.getId())
                .feeName(fee.getFeeName())
                .feeAmount(decimalFormat.format(fee.getFeeAmount()))
                .roomTypeCd(fee.getRoomType().getRoomTypeCd())
                .remark(fee.getRemark())
                .build()).toList();

        long total = queryFeeRepository.feeCountWithComplexConditions(feeSearchDTO);

        return new PageImpl<>(feeResponseDTOList, pageable, total);
    }

    @Override
    public FeeResponseDTO createFee(FeeDTO feeDTO) {
        RoomType roomType = roomTypeRepository.findByRoomTypeCdAndDeletedIsFalse(feeDTO.getRoomTypeCd()).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + feeDTO.getRoomTypeCd()));

        feeRepository.findByFeeName(feeDTO.getFeeName()).
            ifPresent(fee -> {
                throw new IllegalArgumentException("Fee " + feeDTO.getFeeName() + " already exists!");
            });

        Fee newFee = Fee.builder().roomType(roomType)
                .remark(feeDTO.getRemark())
                .feeName(feeDTO.getFeeName())
                .feeAmount(feeDTO.getFeeAmount())
                .isUsed(TRUE)
                .build();

        Fee savedFee = feeRepository.save(newFee);

        return FeeResponseDTO.builder()
                .id(savedFee.getId())
                .roomTypeCd(savedFee.getRoomType().getRoomTypeCd())
                .feeName(savedFee.getFeeName())
                .remark(savedFee.getRemark())
                .build();
    }

    @Override
    public FeeResponseDTO updateFee(FeeDTO feeDTO) {
        Fee fee = feeRepository.findById(feeDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Fee not found with id " + feeDTO.getId()));
        RoomType roomType = roomTypeRepository.findByRoomTypeCdAndDeletedIsFalse(feeDTO.getRoomTypeCd()).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + feeDTO.getRoomTypeCd()));

        fee.changeFeeInfo(feeDTO, roomType);

        Fee savedFee = feeRepository.save(fee);

        return FeeResponseDTO.builder()
                .id(savedFee.getId())
                .roomTypeCd(savedFee.getRoomType().getRoomTypeCd())
                .feeName(savedFee.getFeeName())
                .remark(savedFee.getRemark())
                .build();
    }

    @Override
    public FeeResponseDTO selectFeeById(Long id) {
        Fee fee = feeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fee is not found by " + id));

        return FeeResponseDTO.builder()
                .id(id)
                .feeName(fee.getFeeName())
                .feeAmount(decimalFormat.format(fee.getFeeAmount()))
                .remark(fee.getRemark())
                .roomTypeCd(fee.getRoomType().getRoomTypeCd())
                .build();
    }

    @Override
    public void deleteFee(Long id) {
        Fee fee = feeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fee not found with id " + id));
        fee.delete();
        feeRepository.save(fee);
    }

}
