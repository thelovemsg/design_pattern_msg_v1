package org.reservation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RoomReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomReservationSystemApplication.class, args);
    }

}
