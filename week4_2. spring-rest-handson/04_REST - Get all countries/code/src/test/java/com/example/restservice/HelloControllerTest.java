package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, REST!"));
    }

    @Test
    public void testGreet() throws Exception {
        mockMvc.perform(get("/greet/Kishwar"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, Kishwar!"));
    }

    @Test
    public void testFruits() throws Exception {
        mockMvc.perform(get("/fruits"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0]").value("Apple"))
               .andExpect(jsonPath("$[1]").exists());
    }
}
