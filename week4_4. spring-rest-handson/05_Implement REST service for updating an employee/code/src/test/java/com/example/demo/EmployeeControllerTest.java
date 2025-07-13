package com.example.demo;

import com.example.demo.controller.EmployeeController;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testInvalidIdFormat() throws Exception {
        String invalidJson = "{ \"id\": \"abc\", \"name\": \"John\", \"salary\": 1000, \"permanent\": true, "
                + "\"dateOfBirth\": \"11/07/1990\", \"department\": {\"id\": 1, \"name\": \"HR\"}, "
                + "\"skills\": [{\"id\": 1, \"name\": \"Java\"}] }";

        mockMvc.perform(put("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Incorrect format for field 'id'"));
    }
}
