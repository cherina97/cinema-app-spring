package com.epam.cinema.services.impl;

import com.epam.cinema.dtos.SessionDto;
import com.epam.cinema.exceptions.SessionNotFoundException;
import com.epam.cinema.mappers.SessionMapper;
import com.epam.cinema.models.Session;
import com.epam.cinema.repos.SessionRepository;
import com.epam.cinema.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService, SessionMapper {

    private final SessionRepository sessionRepository;

    @Override
    public SessionDto getSession(int id) {
        Session session = sessionRepository.findById(id)
                .orElseThrow(SessionNotFoundException::new);
        return SessionMapper.INSTANCE.fromSessionToDTO(session);
    }

    @Override
    public SessionDto createSession(SessionDto sessionDto) {
        Session session = SessionMapper.INSTANCE.fromDTOtoSession(sessionDto);
        session = sessionRepository.save(session);
        return SessionMapper.INSTANCE.fromSessionToDTO(session);
    }

    @Override
    public SessionDto updateSession(SessionDto sessionDto, int id) {
        Session session = SessionMapper.INSTANCE.fromDTOtoSession(sessionDto);
        if (sessionRepository.findById(id).isPresent()){
            sessionRepository.save(session);
        } else {
            throw new SessionNotFoundException();
        }
        return SessionMapper.INSTANCE.fromSessionToDTO(session);
    }

    @Override
    public void deleteSession(int id) {
        Session session = sessionRepository.findById(id)
                .orElseThrow(SessionNotFoundException::new);
        sessionRepository.delete(session);
    }

    @Override
    public List<SessionDto> getAllSessions() {
        return sessionRepository.findAll()
                .stream()
                .map(SessionMapper.INSTANCE::fromSessionToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SessionDto fromSessionToDTO(Session session) {
        return new SessionDto.Builder()
                .withId(session.getId())
                .withDate(session.getDate())
                .withTimeStartAt(session.getStartAt())
                .build();
    }

    @Override
    public Session fromDTOtoSession(SessionDto sessionDto) {
        return new Session.Builder()
                .withId(sessionDto.getId())
                .withDate(sessionDto.getDate())
                .withTimeStartAt(sessionDto.getStartAt())
                .build();
    }
}
