package com.epam.cinema.controllers;

import com.epam.cinema.controllers.assemblers.FilmAssembler;
import com.epam.cinema.services.FilmService;
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
class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    @MockBean
    private FilmAssembler filmAssembler;

    @Test
    void getFilm() {
    }

    @Test
    void createFilm() {
    }

    @Test
    void updateFilm() {
    }

    @Test
    void deleteFilm() {
    }

    @Test
    void getAllFilms() {
    }
}