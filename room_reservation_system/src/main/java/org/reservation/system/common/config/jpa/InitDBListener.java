package org.reservation.system.common.config.jpa;

import lombok.RequiredArgsConstructor;
import org.reservation.system.common.config.service.DBInitializerService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDBListener implements ApplicationListener<ApplicationReadyEvent> {

    private final DBInitializerService dbInitializerService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        dbInitializerService.createRoomInfo();
    }
}
