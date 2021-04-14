package com.epam.cinema.controllers;

import com.epam.cinema.controllers.assemblers.FilmAssembler;
import com.epam.cinema.controllers.models.FilmModel;
import com.epam.cinema.dtos.FilmDto;
import com.epam.cinema.services.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/films")
@Slf4j
public class FilmController {
    private final FilmService filmService;
    private final FilmAssembler filmAssembler;

    @GetMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    public FilmModel getFilm(@PathVariable String title) {
        FilmDto film = filmService.getFilm(title);
        return filmAssembler.toModel(film);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FilmModel createFilm(@Valid @RequestBody FilmDto filmDto) {
        log.info("Create film: {}", filmDto);
        FilmDto film = filmService.createFilm(filmDto);
        return filmAssembler.toModel(film);
    }

    @PutMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    public FilmModel updateFilm(@Valid @RequestBody FilmDto filmDto,
                              @PathVariable String title) {
        log.info("Update film: {} to film {}", title, filmDto);
        FilmDto film = filmService.updateFilm(filmDto, title);
        return filmAssembler.toModel(film);
    }

    @DeleteMapping(value = "/{title}")
    public ResponseEntity<Void> deleteFilm(@PathVariable String title) {
        log.info("Delete film by title: {}", title);
        filmService.deleteFilm(title);
        return ResponseEntity.noContent().build();
    }
}
