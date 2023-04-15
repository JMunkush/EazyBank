package io.munkush.com.unit.controller;

import io.munkush.com.controller.LoansController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
@WebMvcTest(LoansController.class)
class LoansControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser
    void shouldReturnStatus200() throws Exception{
        mockMvc.perform(get("/myLoans"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnStatus4xx() throws Exception {
        mockMvc.perform(get("/myLoans"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithMockUser
    void shouldReturnStringContent() throws Exception{
        mockMvc.perform(get("/myLoans"))
                .andExpect(content().string("Here are the loan details from the DB"));
    }
}