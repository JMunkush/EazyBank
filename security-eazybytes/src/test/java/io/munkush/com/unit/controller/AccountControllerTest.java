package io.munkush.com.unit.controller;

import io.munkush.com.controller.AccountController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser
    void shouldReturnStatus200() throws Exception {

        mockMvc.perform(get("/myAccount"))
                .andExpect(status().isOk());
    }


    @Test
    void shouldReturnStatus4xx() throws Exception {
        mockMvc.perform(get("/myAccount"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithMockUser
    void shouldReturnStringContent() throws Exception{
        mockMvc.perform(get("/myAccount"))
                .andExpect(content().string("Here are the account details from the DB"));
    }
}