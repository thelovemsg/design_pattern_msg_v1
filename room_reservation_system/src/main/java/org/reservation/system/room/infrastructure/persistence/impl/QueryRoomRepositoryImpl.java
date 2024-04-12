package org.reservation.system.room.infrastructure.persistence.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.vo.RoomReservationQuery;
import org.reservation.system.room.application.dto.RoomCurrentStatusDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.vo.RoomBlockVO;
import org.reservation.system.room.application.vo.RoomVO;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.reservation.system.room.infrastructure.persistence.QueryRoomRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static org.reservation.system.reservation.domain.model.QReservation.reservation;
import static org.reservation.system.reservation.domain.model.other.QRoomReservation.roomReservation;
import static org.reservation.system.room.domain.model.QRoom.room;
import static org.reservation.system.room.domain.model.QRoomAndRoomBlock.roomAndRoomBlock;

@Repository
@RequiredArgsConstructor
public class QueryRoomRepositoryImpl implements QueryRoomRepository {

    private final JPAQueryFactory queryFactory;
    private final RoomTypeRepository roomTypeRepository;

    @Override
    public List<Room> findRoomWithComplexConditions(Pageable pageable, RoomSearchDTO roomSearchDTO) {
        return queryFactory.selectFrom(room)
                .where(eqRoomNo(roomSearchDTO.getRoomNo())
                        , eqRoomType(roomSearchDTO.getRoomTypeCd())
                        , containRoomName(roomSearchDTO.getRoomName())
                        , containRemark(roomSearchDTO.getRemark())
                        , room.deleted.eq(FALSE))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public long countRoomWithComplexConditions(RoomSearchDTO roomSearchDTO) {
        return queryFactory.selectFrom(room)
                .where(eqRoomNo(roomSearchDTO.getRoomNo())
                        , eqRoomType(roomSearchDTO.getRoomTypeCd())
                        , containRoomName(roomSearchDTO.getRoomName())
                        , containRemark(roomSearchDTO.getRemark())
                        , room.deleted.eq(FALSE))
                .fetch().stream().count();
    }

    @Override
    public List<RoomVO> findAnyReservedRoomByReservationInfo(RoomReservationQuery roomReservationQuery) {
        LocalDate enterRoomDate = roomReservationQuery.enterRoomDate();
        LocalDate leaveRoomDate = enterRoomDate.plusDays(roomReservationQuery.stayDayCnt() + 1L);
        return queryFactory.select(Projections.constructor(RoomVO.class, room.roomNo, room.roomName, room.roomType, room.remark))
                .from(roomReservation)
                .join(roomReservation.reservation, reservation)
                .where(reservation.reservationInfo.enterRoomDate.before(leaveRoomDate)
                        .and(reservation.reservationInfo.leaveRoomDate.after(enterRoomDate))
                        .and(reservation.deleted.eq(FALSE))
                        .and(room.id.eq(roomReservationQuery.roomId()))
                ).fetch();
    }

    @Override
    public RoomBlockVO findBlockRoomInfoByReservationInfo(RoomReservationQuery roomReservationQuery) {
        LocalDate enterRoomDate = roomReservationQuery.enterRoomDate();
        LocalDate exitRoomDate = roomReservationQuery.enterRoomDate().plusDays(roomReservationQuery.stayDayCnt());

        return queryFactory.select(Projections.constructor(RoomBlockVO.class,
                        roomAndRoomBlock.room.roomNo
                        , roomAndRoomBlock.roomBlock.roomBlockType
                        , roomAndRoomBlock.roomBlock.blockStartDate
                        , roomAndRoomBlock.roomBlock.blockEndPlanDate
                        , roomAndRoomBlock.roomBlock.blockEndDate))
                .from(roomAndRoomBlock)
                .join(roomAndRoomBlock.room, room)
                .where(room.id.eq(roomReservationQuery.roomId())
                        .and(roomAndRoomBlock.roomBlock.blockStartDate.loe(exitRoomDate.atStartOfDay(ZoneId.systemDefault())))
                        .and(roomAndRoomBlock.roomBlock.blockEndDate.goe(enterRoomDate.atStartOfDay(ZoneId.systemDefault()))))
                .fetchOne();
    }

    @Override
    public List<RoomCurrentStatusDTO> findRoomCurrentStatusByRoomTypes(RoomSearchDTO roomSearchDTO) {
        LocalDate startDate = roomSearchDTO.getStartDate();
        LocalDate endDate = roomSearchDTO.getEndDate();

        Map<LocalDate, RoomCurrentStatusDTO> statusByDate = IntStream.rangeClosed(0, Period.between(startDate, endDate).getDays())
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toMap(
                        date -> date,
                        RoomCurrentStatusDTO::new,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new)
                );

        Long roomCount = queryFactory.select(room.count())
                .from(room)
                .where(room.deleted.eq(false)
                        .and(room.useFlag.eq("1")))
                .fetchOne();

        List<Tuple> fetch = queryFactory.select(roomReservation.count(), roomReservation.reservation.reservationInfo.enterRoomDate, room.roomType.roomTypeCd, room.roomType.id)
                .from(roomReservation)
                .join(roomReservation.room, room)
                .where(roomReservation.reservation.reservationInfo.enterRoomDate.loe(endDate)
                        .and(roomReservation.reservation.reservationInfo.leaveRoomDate.goe(startDate))
                        .and(roomReservation.deleted.eq(false)))
                .groupBy(roomReservation.reservation.reservationInfo.enterRoomDate, room.roomType.roomTypeCd, room.roomType.id)
                .fetch();

        fetch.parallelStream().forEach(tuple -> {
            LocalDate enterRoomDate = tuple.get(roomReservation.reservation.reservationInfo.enterRoomDate);
            String roomTypeCd = tuple.get(room.roomType.roomTypeCd);
            Long id = tuple.get(room.roomType.id);
            Long count = tuple.get(roomReservation.count());

            RoomCurrentStatusDTO statusDto = statusByDate.get(enterRoomDate);
            statusDto.addRoomTotalCount(roomTypeCd, count, id);
        });

        statusByDate.values().forEach(el -> el.calculateRoomReservationRate(roomCount));

        return new ArrayList<>(statusByDate.values());
    }

    private BooleanExpression eqRoomNo(Integer roomNo) {
        if (roomNo == null) {
            return null;
        }

        return room.roomNo.eq(roomNo);
    }

    private BooleanExpression eqRoomType(String roomTypeCd) {
        if (StringUtils.isEmpty(roomTypeCd)) {
            return null;
        }

        RoomType roomType = roomTypeRepository.findByRoomTypeCdAndDeletedIsFalse(roomTypeCd).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + roomTypeCd));

        if (roomType == null) {
            return null;
        }

        return room.roomType.eq(roomType);
    }

    private BooleanExpression containRoomName(String roomName) {
        if (StringUtils.isEmpty(roomName)) {
            return null;
        }

        return room.roomName.stringValue().containsIgnoreCase(roomName);
    }

    private BooleanExpression containRemark(String remark) {
        if (StringUtils.isEmpty(remark)) {
            return null;
        }

        return room.remark.stringValue().containsIgnoreCase(remark);
    }
}
