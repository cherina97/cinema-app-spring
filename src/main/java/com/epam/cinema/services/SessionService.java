package com.epam.cinema.services;

import com.epam.cinema.dtos.SessionDto;

import java.util.List;

public interface SessionService {

    SessionDto getSession(int id);

    SessionDto createSession(SessionDto sessionDto);

    SessionDto updateSession(SessionDto sessionDto, int id);

    void deleteSession(int id);

    List<SessionDto> getAllSessions();
}
