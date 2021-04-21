package com.epam.cinema.controllers;

import com.epam.cinema.controllers.assemblers.GenreAssembler;
import com.epam.cinema.services.GenreService;
import com.epam.cinema.test.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
class GenreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenreService genreService;

    @MockBean
    private GenreAssembler genreAssembler;

    @Test
    void getGenre() {
    }

    @Test
    void createGenre() {
    }

    @Test
    void updateGenre() {
    }

    @Test
    void deleteGenre() {
    }

    @Test
    void getAllGenres() {
    }
}