package de.neuefische.ffmjava221.auth.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExcavatorIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void expect401_withoutValidUser() throws Exception {
        mockMvc.perform(get("/api/excavators"))
                .andExpect(status().is(401));
    }

    @Test
    @WithMockUser
    void expect401_withValidUser() throws Exception {
        mockMvc.perform(get("/api/excavators"))
                .andExpect(status().is(200));
    }

}
