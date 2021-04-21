package com.epam.cinema.controllers;

import com.epam.cinema.controllers.assemblers.SessionAssembler;
import com.epam.cinema.controllers.assemblers.UserAssembler;
import com.epam.cinema.services.SessionService;
import com.epam.cinema.services.UserService;
import com.epam.cinema.test.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
class SessionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SessionService sessionService;

    @MockBean
    private SessionAssembler sessionAssembler;

    @Test
    void getSession() {
    }

    @Test
    void createSession() {
    }

    @Test
    void updateSession() {
    }

    @Test
    void deleteSession() {
    }

    @Test
    void getAllSessions() {
    }
}