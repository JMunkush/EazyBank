package io.munkush.com.unit.controller;

import io.munkush.com.controller.NoticesController;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitConfig
@WebMvcTest(NoticesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class NoticesControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @SneakyThrows
    void shouldReturnStringContentAndStatusOk(){
        mockMvc.perform(get("/notices"))
                .andExpect(status().isOk())
                .andExpect(content().string("Here are the notices details from the DB"));
    }
}
