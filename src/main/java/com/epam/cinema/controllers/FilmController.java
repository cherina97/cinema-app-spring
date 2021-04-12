package com.epam.cinema.controllers;

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

    @GetMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    public FilmDto getFilm(@PathVariable String title) {
        return filmService.getFilm(title);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FilmDto createFilm(@Valid @RequestBody FilmDto filmDto) {
        log.info("Create film: {}", filmDto);
        return filmService.createFilm(filmDto);
    }

    @PutMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    public FilmDto updateFilm(@Valid @RequestBody FilmDto filmDto,
                              @PathVariable String title) {
        log.info("Update film: {} to film {}", title, filmDto);
        return filmService.updateFilm(filmDto, title);
    }

    @DeleteMapping(value = "/{title}")
    public ResponseEntity<Void> deleteFilm(@PathVariable String title) {
        log.info("Delete film by title: {}", title);
        filmService.deleteFilm(title);
        return ResponseEntity.noContent().build();
    }
}
