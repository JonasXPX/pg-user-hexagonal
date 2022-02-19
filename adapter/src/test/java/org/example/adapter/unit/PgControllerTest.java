package org.example.adapter.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.adapter.controller.PgController;
import org.example.model.PgService;
import org.example.model.data.PgUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class PgControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    PgService service;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        doNothing().when(service).save(any(PgUser.class));
    }

    @Test
    void shouldReturnOkWhenSavePgUser() throws Exception {
        PgUser pgUser = new PgUser(1L, "test");
        mockMvc.perform(post("/pg-user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pgUser)))
                .andExpect(status().isOk());
    }



}
