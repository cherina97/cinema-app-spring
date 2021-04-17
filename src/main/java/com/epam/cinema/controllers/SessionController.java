package com.epam.cinema.controllers;

import com.epam.cinema.controllers.assemblers.SessionAssembler;
import com.epam.cinema.controllers.models.SessionModel;
import com.epam.cinema.dtos.SessionDto;
import com.epam.cinema.services.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SessionController implements com.epam.cinema.api.SessionApi {

    private final SessionService sessionService;
    private final SessionAssembler sessionAssembler;

    @Override
    public SessionModel getSession(int id){
        SessionDto session = sessionService.getSession(id);
        return sessionAssembler.toModel(session);
    }

    @Override
    public SessionModel createSession(SessionDto sessionDto){
        SessionDto session = sessionService.createSession(sessionDto);
        return sessionAssembler.toModel(session);
    }

    @Override
    public SessionModel updateSession(SessionDto sessionDto, int id){
        SessionDto session = sessionService.updateSession(sessionDto, id);
        return sessionAssembler.toModel(session);
    }

    @Override
    public ResponseEntity<Void> deleteSession(int id){
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<SessionModel> getAllSessions(){
        return sessionService.getAllSessions()
                .stream()
                .map(sessionAssembler::toModel)
                .collect(Collectors.toList());
    }


}
