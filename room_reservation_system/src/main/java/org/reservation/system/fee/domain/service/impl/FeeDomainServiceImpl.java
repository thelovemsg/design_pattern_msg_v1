package org.reservation.system.fee.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.calander.application.service.CalenderService;
import org.reservation.system.calander.application.service.enums.DayDivEnum;
import org.reservation.system.calander.domain.Calender;
import org.reservation.system.fee.application.dto.DailyFeeDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.TempDailyFeeFactory;
import org.reservation.system.fee.domain.model.DailyRoomFee;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.fee.domain.model.PricingHistory;
import org.reservation.system.fee.domain.model.TempDailyFee;
import org.reservation.system.fee.domain.repository.FeeRepository;
import org.reservation.system.fee.domain.service.FeeDomainService;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;
import org.reservation.system.fee.domain.service.pricing.impl.SeasonSurchargeByFixedAmountImpl;
import org.reservation.system.fee.domain.service.pricing.impl.SeasonSurchargeByRateImpl;
import org.reservation.system.fee.infrastructure.persistence.DailyRoomFeeRepository;
import org.reservation.system.fee.infrastructure.persistence.PricingHistoryRepository;
import org.reservation.system.fee.infrastructure.persistence.QueryFeeRepository;
import org.reservation.system.fee.infrastructure.persistence.TempDailyFeeRepository;
import org.reservation.system.fee.value.Money;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeDomainServiceImpl implements FeeDomainService {

    private final FeeRepository feeRepository;
    private final DailyRoomFeeRepository dailyRoomFeeRepository;
    private final QueryFeeRepository queryFeeRepository;
    private final CalenderService calenderService;
    private final PricingHistoryRepository PricingHistoryRepository;
    private final TempDailyFeeRepository tempDailyFeeRepository;
    private final TempDailyFeeFactory tempDailyFeeFactory;

    @Override
    public DailyFeeDTO createDailyFee(Fee fee, Calender calender) {


        return null;
    }

    @Override
    public List<DailyFeeDTO> createTempDailyFee(FeeSearchDTO feeSearchDTO) {

        List<DailyFeeDTO> result = new ArrayList<>();

        // 1. 예약하려는 객실의 요금을 찾는다.
        Fee fee = queryFeeRepository.findOneFeeWithConditions(feeSearchDTO);
        if (fee == null)
            throw new IllegalArgumentException("fee is not exist");
        LocalDate enterRoomDate = feeSearchDTO.getEnterRoomDate();
        LocalDate leaveRoomDate = enterRoomDate.plusDays(feeSearchDTO.getStayDayCnt()).minusDays(1);

        // 2. 예약하려는 기간의 날짜 정보를 조회한다.
        List<Calender> calenders = calenderService.selectCalenderInfoBySolarDateBetween(enterRoomDate, leaveRoomDate);

        // 3. 예약하려는 날짜 정보에 맞춰서 fee에 요금을 적용해서 일별 요금을 생성한다.
        for (Calender calender : calenders) {

            TempDailyFee tempDailyFee = tempDailyFeeFactory.create(fee, calender);
            applySeasonalPricing(calender, tempDailyFee);
            if (DayDivEnum.isPeakOfWeek(calender.getDayDivCd())) {
                // 해당 주의 금요일 혹은 토요일인 경우 추가 요금 적용
            }

            // 이벤트성 할인 적용

            DailyRoomFee dailyRoomFee = new DailyRoomFee();

            //적용한 요금을

            dailyRoomFeeRepository.save(dailyRoomFee);

//            result.add(createDailyFee(fee, calender));
        }

        return result;
    }

    private void applySeasonalPricing(Calender calender, TempDailyFee tempDailyFee) {
        if (calender.getSeasonDivCd().equals("Y")) {
            SurchargingStrategy surchargingStrategy = null;
            if (shouldUseFixedAmountStrategy()) {
                surchargingStrategy = new SeasonSurchargeByFixedAmountImpl();
            } else {
                surchargingStrategy = new SeasonSurchargeByRateImpl();
            }

            PriceVO surchargedPrice = surchargingStrategy.surchargeFee(tempDailyFee.getMoney().getSalesAmount());

            PricingHistory pricingHistory = PricingHistory.builder()
                    .tempDailyFee(tempDailyFee) // 앞서 생성된 TempDailyFee의 참조 설정
                    .applyReason("Seasonal Surcharge")
                    .pricingType("SURCHARGE")
                    .appliedPrice(surchargedPrice.getSurchargedPrice())
                    .build();
            PricingHistoryRepository.save(pricingHistory);
        }
    }

    private boolean shouldUseFixedAmountStrategy() {
        // TODO : 현재 선택한 정책에 따라서 고르도록 함.
        return true;
    }

    @Override
    public List<DailyFeeDTO> applyDiscountPolicy(Fee fee) {
        return null;
    }
}

