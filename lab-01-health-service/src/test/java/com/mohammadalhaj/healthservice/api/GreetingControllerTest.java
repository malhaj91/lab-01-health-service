package com.mohammadalhaj.healthservice.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnPersonalizedGreeting() throws Exception {
        mockMvc.perform(get("/api/v1/greetings")
                        .param("name", "Mohammad"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello, Mohammad!"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void shouldUseDefaultNameWhenNameIsMissing() throws Exception {
        mockMvc.perform(get("/api/v1/greetings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello, Developer!"))
                .andExpect(jsonPath("$.timestamp").exists());
    }
}