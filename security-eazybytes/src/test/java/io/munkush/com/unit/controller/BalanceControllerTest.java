package io.munkush.com.unit.controller;

import io.munkush.com.controller.BalanceController;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
@WebMvcTest(BalanceController.class)
class BalanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void shouldReturnStatus200() throws Exception{
        mockMvc.perform(get("/myBalance"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnStatus3xx() throws Exception{
        mockMvc.perform(get("/myBalance"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithMockUser
    void shouldReturnStringContent() throws Exception{
        mockMvc.perform(get("/myBalance"))
                .andExpect(content().string("Here are the balance details from the DB"));
    }

}