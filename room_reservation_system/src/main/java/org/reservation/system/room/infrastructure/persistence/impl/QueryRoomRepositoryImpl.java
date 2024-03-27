package org.reservation.system.room.infrastructure.persistence.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.reservation.system.room.infrastructure.persistence.QueryRoomRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static org.reservation.system.room.domain.model.QRoom.room;

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
