package org.reservation.system.fee.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.calander.application.service.CalenderService;
import org.reservation.system.calander.application.service.enums.DayDivEnum;
import org.reservation.system.calander.domain.Calender;
import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.dto.PricingHistoryDTO;
import org.reservation.system.fee.application.enums.ChargeEnum;
import org.reservation.system.fee.application.vo.FeeCreateVO;
import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.TempDailyFeeFactory;
import org.reservation.system.fee.domain.model.*;
import org.reservation.system.fee.domain.service.FeeDomainService;
import org.reservation.system.fee.domain.service.factory.SurgingStrategyFactory;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;
import org.reservation.system.fee.infrastructure.persistence.*;
import org.reservation.system.fee.value.MoneyInfo;
import org.reservation.system.reservation.domain.model.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeeDomainServiceImpl implements FeeDomainService {

    private final DailyRoomFeeRepository dailyRoomFeeRepository;
    private final QueryFeeRepository queryFeeRepository;
    private final CalenderService calenderService;
    private final PricingHistoryRepository pricingHistoryRepository;
    private final TempDailyFeeFactory tempDailyFeeFactory;
    private final EventRepository eventRepository;
    private final SurgingStrategyFactory surgingStrategyFactory;
    private final TempDailyFeeRepository tempDailyFeeRepository;


    @Override
    @Transactional
    public List<DailyRoomFeeDTO> createTempDailyFee(FeeSearchDTO feeSearchDTO) {

        List<DailyRoomFeeDTO> result = new ArrayList<>();
        Fee fee = queryFeeRepository.findOneFeeWithConditions(feeSearchDTO);

        if (fee == null)
            throw new IllegalArgumentException("fee is not exist");
        LocalDate enterRoomDate = feeSearchDTO.getEnterRoomDate();
        LocalDate leaveRoomDate = enterRoomDate.plusDays(feeSearchDTO.getStayDayCnt());

        List<Calender> calenders = calenderService.selectCalenderInfoBySolarDateExceptEndDate(enterRoomDate, leaveRoomDate);

        for (Calender calender : calenders) {
            List<PricingHistory> pricingHistoryList = new ArrayList<>();
            List<PricingHistoryDTO> pricingHistoryDTOList = new ArrayList<>();

            TempDailyFee tempDailyFee = tempDailyFeeFactory.create(fee, calender);
            applyPrices(calender, tempDailyFee, pricingHistoryList);

            for (PricingHistory pricingHistory : pricingHistoryList) {
                pricingHistoryDTOList.add(PricingHistoryDTO.builder()
                        .appliedPrice(pricingHistory.getAppliedPrice())
                        .pricingType(pricingHistory.getPricingType().toString())
                        .applyReason(pricingHistory.getApplyReason())
                        .build());
            }

            DailyRoomFeeDTO dailyRoomFeeDTO = DailyRoomFeeDTO.builder()
                    .feeName(fee.getFeeName())
                    .salesAmount(tempDailyFee.getMoneyInfo().getSalesAmount())
                    .addedAmount(tempDailyFee.getMoneyInfo().getAddedAmount())
                    .discountAmount(tempDailyFee.getMoneyInfo().getDiscountAmount())
                    .occurDate(calender.getSolarDate())
                    .productAmount(fee.getFeeAmount())
                    .pricingHistoryDTOList(pricingHistoryDTOList)
                    .build();

            result.add(dailyRoomFeeDTO);
        }

        return result;
    }

    private void applyPrices(Calender calender, TempDailyFee tempDailyFee, List<PricingHistory> pricingHistoryList) {
        applySeasonalPricing(calender, tempDailyFee).ifPresent(pricingHistoryList::add);
        applyPeakPricing(calender, tempDailyFee).ifPresent(pricingHistoryList::add);
        applyEventPricing(calender, tempDailyFee).ifPresent(pricingHistoryList::addAll);
    }

    private Optional<PricingHistory> applySeasonalPricing(Calender calender, TempDailyFee tempDailyFee) {
        if (calender.getSeasonDivCd().equals("Y")) {
            SurchargingStrategy surchargingStrategy = surgingStrategyFactory.getSeasonalStrategy();
            PriceVO surchargedPrice = surchargingStrategy.surchargeFee(tempDailyFee.getMoneyInfo());
            tempDailyFee.changeMoneyInfo(updateMoneyInfo(tempDailyFee.getMoneyInfo(), surchargedPrice.getSurchargedPrice(), ChargeEnum.CHARGE));

            PricingHistory pricingHistory = PricingHistory.builder()
                    .tempDailyFee(tempDailyFee)
                    .applyReason("Seasonal Surcharge")
                    .pricingType(ChargeEnum.CHARGE)
                    .appliedPrice(surchargedPrice.getSurchargedPrice())
                    .build();
            return Optional.of(pricingHistoryRepository.save(pricingHistory));
        }

        return Optional.empty();
    }

    private Optional<PricingHistory> applyPeakPricing(Calender calender, TempDailyFee tempDailyFee) {
        if (DayDivEnum.isPeakOfWeek(calender.getDayDivCd())) {
            SurchargingStrategy surchargingStrategy = surgingStrategyFactory.getPeakStrategy();

            PriceVO surchargedPrice = surchargingStrategy.surchargeFee(tempDailyFee.getMoneyInfo());
            tempDailyFee.changeMoneyInfo(updateMoneyInfo(tempDailyFee.getMoneyInfo(), surchargedPrice.getSurchargedPrice(), ChargeEnum.CHARGE));

            PricingHistory pricingHistory = PricingHistory.builder()
                    .tempDailyFee(tempDailyFee)
                    .applyReason("Peak Surcharge")
                    .pricingType(ChargeEnum.CHARGE)
                    .appliedPrice(surchargedPrice.getSurchargedPrice())
                    .build();
            return Optional.of(pricingHistoryRepository.save(pricingHistory));
        }

        return Optional.empty();
    }

    private Optional<List<PricingHistory>> applyEventPricing(Calender calender, TempDailyFee tempDailyFee) {
        List<PricingHistory> result = new ArrayList<>();
        List<Event> eventList = eventRepository.findByDateBetween(calender.getSolarDate());
        MoneyInfo moneyInfo = tempDailyFee.getMoneyInfo();
        for (Event event : eventList) {

            MoneyInfo updatedMoneyInfo = updateMoneyInfo(moneyInfo, event.getChargeAmount(), event.getChargeDivCd());

            PricingHistory pricingHistory = PricingHistory.builder()
                    .tempDailyFee(tempDailyFee) // 앞서 생성된 TempDailyFee의 참조 설정
                    .applyReason("Event Pricing")
                    .pricingType(event.getChargeDivCd())
                    .appliedPrice(updatedMoneyInfo.getDifferentAmount())
                    .build();

            moneyInfo = updatedMoneyInfo;

            result.add(pricingHistoryRepository.save(pricingHistory));
        }

        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }


    private MoneyInfo updateMoneyInfo(MoneyInfo moneyInfo, BigDecimal chargeAmount, ChargeEnum chargeEnum) {
        return chargeEnum == ChargeEnum.CHARGE ? moneyInfo.addAmount(chargeAmount) : moneyInfo.subtractAmount(chargeAmount);
    }

    @Override
    public List<DailyRoomFeeDTO> applyDiscountPolicy(Fee fee) {
        return null;
    }

    @Override
    public List<DailyRoomFeeDTO> createDailyRoomFeeByTemp(Reservation reservation, FeeCreateVO feeCreateVO) {

        List<DailyRoomFeeDTO> dailyRoomFeeDTOList = new ArrayList<>();

        List<TempDailyFee> tempDailyFeeList = tempDailyFeeRepository.findByOccurDateBetween(feeCreateVO.getEnterRoomDate(), feeCreateVO.getEnterRoomDate().plusDays(feeCreateVO.getStayDayCnt()))
                .orElseThrow(() -> new IllegalArgumentException("No Fee Exists"));


        for (TempDailyFee tempDailyFee : tempDailyFeeList) {
            DailyRoomFee dailyRoomFee = DailyRoomFee.builder()
                    .fee(tempDailyFee.getFee())
                    .occurDate(tempDailyFee.getOccurDate())
                    .reservation(reservation)
                    .moneyInfo(tempDailyFee.getMoneyInfo())
                    .build();

            List<PricingHistory> pricingHistoryList = new ArrayList<>(tempDailyFee.getPricingHistoryList());

            for (PricingHistory pricingHistory : pricingHistoryList) {
                PricingHistory newPricingHistory = PricingHistory
                                                        .builder()
                                                        .appliedPrice(pricingHistory.getAppliedPrice())
                                                        .applyReason(pricingHistory.getApplyReason())
                                                        .pricingType(pricingHistory.getPricingType())
                                                        .build();
                dailyRoomFee.addPricingHistory(newPricingHistory);
            }


            DailyRoomFee savedDailyRoomFee = dailyRoomFeeRepository.save(dailyRoomFee);
            dailyRoomFeeDTOList.add(savedDailyRoomFee.entityToDTO(dailyRoomFee));
        }

        return dailyRoomFeeDTOList;
    }
}

