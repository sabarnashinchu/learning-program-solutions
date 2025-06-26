package com.example.demo;

import com.example.demo.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookControllerIntegrationTest {

    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper mapper;

    private static Long createdId;

    @Test @Order(1)
    void createBook() throws Exception {
        Book b = new Book("Clean Code", "Robert C. Martin");
        String json = mapper.writeValueAsString(b);

        String location =
            mvc.perform(post("/books")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(json))
               .andExpect(status().isCreated())
               .andReturn().getResponse().getHeader("Location");

        assertThat(location).isNotNull();
        createdId = Long.valueOf(location.substring(location.lastIndexOf('/') + 1));
    }

    @Test @Order(2)
    void listContainsCreatedBook() throws Exception {
        mvc.perform(get("/books"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].title").value("Clean Code"));
    }

    @Test @Order(3)
    void fetchById() throws Exception {
        mvc.perform(get("/books/{id}", createdId))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.author").value("Robert C. Martin"));
    }
}
