package com.epam.cinema.api;

import com.epam.cinema.controllers.models.SessionModel;
import com.epam.cinema.dtos.SessionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Session management API")
@RequestMapping("/api/v1/sessions")
public interface SessionApi {

    @ApiOperation("Get session from Database")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    SessionModel getSession(@PathVariable int id);

    @ApiOperation("Creating session")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    SessionModel createSession(@Valid @RequestBody SessionDto sessionDto);

    @ApiOperation("Update session")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    SessionModel updateSession(@Valid @RequestBody SessionDto sessionDto, @PathVariable int id);

    @ApiOperation("Delete session from Database")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteSession(@PathVariable int id);

    @ApiOperation("Getting all sessions from Database")
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    List<SessionModel> getAllSessions();
}
