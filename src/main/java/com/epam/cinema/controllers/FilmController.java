package com.epam.cinema.controllers;

import com.epam.cinema.api.FilmApi;
import com.epam.cinema.controllers.assemblers.FilmAssembler;
import com.epam.cinema.controllers.models.FilmModel;
import com.epam.cinema.dtos.FilmDto;
import com.epam.cinema.services.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class FilmController implements FilmApi {
    private final FilmService filmService;
    private final FilmAssembler filmAssembler;

    @Override
    public FilmModel getFilm(String title) {
        FilmDto film = filmService.getFilm(title);
        return filmAssembler.toModel(film);
    }

    @Override
    public FilmModel createFilm(FilmDto filmDto) {
        log.info("Create film: {}", filmDto);
        FilmDto film = filmService.createFilm(filmDto);
        return filmAssembler.toModel(film);
    }

    @Override
    public FilmModel updateFilm(FilmDto filmDto,
                                String title) {
        log.info("Update film: {} to film {}", title, filmDto);
        FilmDto film = filmService.updateFilm(filmDto, title);
        return filmAssembler.toModel(film);
    }

    @Override
    public ResponseEntity<Void> deleteFilm(String title) {
        log.info("Delete film by title: {}", title);
        filmService.deleteFilm(title);
        return ResponseEntity.noContent().build();
    }
}
