package com.epam.cinema.controllers;

import com.epam.cinema.models.Genre;
import com.epam.cinema.services.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/genres")
@Slf4j
public class GenreController {
    private final GenreService genreService;

    @GetMapping(value = "/{genreName}")
    @ResponseStatus(HttpStatus.OK)
    public Genre getGenre(@PathVariable String genreName) {
        return genreService.getGenre(genreName);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Genre createGenre(@Valid @RequestBody Genre genre) {
        log.info("Create genre: {}", genre);
        return genreService.createGenre(genre);
    }

    @PutMapping(value = "/{genreName}")
    @ResponseStatus(HttpStatus.OK)
    public Genre updateGenre(@Valid @RequestBody Genre genre,
                           @PathVariable String genreName) {
        log.info("Update genre: {} to genre {}", genreName, genre);
        return genreService.updateGenre(genre, genreName);
    }

    @DeleteMapping(value = "/{genreName}")
    public ResponseEntity<Void> deleteGenre(@PathVariable String genreName) {
        log.info("Delete genre by title: {}", genreName);
        genreService.deleteGenre(genreName);
        return ResponseEntity.noContent().build();
    }
}
