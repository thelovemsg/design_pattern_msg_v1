package org.reservation.system.room;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.room.application.service.RoomService;
import org.reservation.system.room.application.service.RoomTypeService;
import org.reservation.system.room.interfaces.RoomController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @Mock
    private RoomTypeService roomTypeService;

    @InjectMocks
    private RoomController roomController;
    private MockMvc mockMvc;
    private Gson gson;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(roomController)
                .build();
        gson = new Gson(); // Gson 객체 초기화
    }

    @Test
    void mockMvcIsNotNull() {
        assertThat(roomController).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void 객실생성실패_필수값누락() throws Exception {
        final String url = "/rooms/new";

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("roomType","")
                        .param("roomNo","")
                         .param("remark","")
                        .param("roomName","")
                )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("roomDTO", "roomNo")) // 모델에 특정 필드에 대한 오류가 있는지 확인
                .andExpect(model().attributeHasFieldErrors("roomDTO", "roomName")) // 모델에 특정 필드에 대한 오류가 있는지 확인
                .andExpect(model().attributeHasFieldErrors("roomDTO", "roomTypeCd")) // 모델에 특정 필드에 대한 오류가 있는지 확인
                .andExpect(model().attributeErrorCount("roomDTO", 3)); // 오류 개수가 예상과 일치하는지 확인
    }
}
