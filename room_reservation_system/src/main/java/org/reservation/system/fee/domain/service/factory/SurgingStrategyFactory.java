package org.reservation.system.fee.domain.service.factory;

import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;
import org.reservation.system.fee.domain.service.pricing.surcharge.impl.peak.PeakSurchargeByFixedAmountImpl;
import org.reservation.system.fee.domain.service.pricing.surcharge.impl.peak.PeakSurchargeByRateImpl;
import org.reservation.system.fee.domain.service.pricing.surcharge.impl.season.SeasonSurchargeByFixedAmountImpl;
import org.reservation.system.fee.domain.service.pricing.surcharge.impl.season.SeasonSurchargeByRateImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurgingStrategyFactory {

    private final PeakSurchargeByFixedAmountImpl peakFixed;
    private final PeakSurchargeByRateImpl peakRate;
    private final SeasonSurchargeByFixedAmountImpl seasonFixed;
    private final SeasonSurchargeByRateImpl seasonRate;

    public SurchargingStrategy getPeakStrategy() {
        return true ? peakFixed : peakRate;
    }

    public SurchargingStrategy getSeasonalStrategy() {
        return true ? seasonFixed : seasonRate;
    }
}
