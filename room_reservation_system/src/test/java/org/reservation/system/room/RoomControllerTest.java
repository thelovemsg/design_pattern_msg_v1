package org.reservation.system.room;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reservation.system.room.application.dto.RoomCreationDTO;
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
        final String url = "/rooms";

        // 필수 필드 중 일부를 누락한 요청 본문 생성
        RoomCreationDTO roomCreationDTO = RoomCreationDTO.builder().roomName("test room").build();

        // roomNo와 roomType은 누락되었다고 가정합니다.
//        String jsonContent = gson.toJson(roomCreationDTO);

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("roomType","type")
                        .param("roomNo","")
                        .param("remark","")
                        .param("roomName","")
                )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("roomCreationDto", "roomNo")) // 모델에 특정 필드에 대한 오류가 있는지 확인
                .andExpect(model().attributeErrorCount("roomCreationDto", 3)); // 오류 개수가 예상과 일치하는지 확인
    }
}
