package org.reservation.system.room.infrastructure.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.QueryRoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

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
                        , containRemark(roomSearchDTO.getRemark()))
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
                        , containRemark(roomSearchDTO.getRemark()))
                .fetch().stream().count();
    }

    private BooleanExpression eqRoomNo(Integer roomNo) {
        if (roomNo == null) {
            return null;
        }

        return room.roomNo.eq(roomNo);
    }

    private BooleanExpression eqRoomType(String roomTypeCd) {
        if (roomTypeCd == null || roomTypeCd.equals("")) {
            return null;
        }
        RoomType roomType = roomTypeRepository.findByRoomTypeCd(roomTypeCd).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + roomTypeCd));

        if (roomType == null) {
            return null;
        }

        return room.roomType.eq(roomType);
    }

    private BooleanExpression containRoomName(String roomName) {
        if (roomName == null || roomName.equals("")) {
            return null;
        }

        return room.roomNo.stringValue().containsIgnoreCase(roomName);
    }

    private BooleanExpression containRemark(String remark) {
        if (remark == null || remark.equals("")) {
            return null;
        }

        return room.remark.stringValue().containsIgnoreCase(remark);
    }
}
