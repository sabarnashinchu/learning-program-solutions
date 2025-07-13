// src/test/java/com/cognizant/spring_learn/SpringLearnApplicationTests.java
package com.cognizant.spring_learn;

import com.cognizant.spring_learn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    // ✅ Test 1: Controller Loaded
    @Test
    public void contextLoads() {
        assertNotNull(countryController);
    }

    // ✅ Test 2: /country API returns expected JSON
    @Test
    public void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/country"));
        actions.andExpect(status().isOk());                       // HTTP 200
        actions.andExpect(jsonPath("$.code").exists());           // code field exists
        actions.andExpect(jsonPath("$.code").value("IN"));        // code = IN
        actions.andExpect(jsonPath("$.name").exists());           // name field exists
        actions.andExpect(jsonPath("$.name").value("India"));     // name = India
    }
}
