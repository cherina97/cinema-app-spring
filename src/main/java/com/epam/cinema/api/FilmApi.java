package com.epam.cinema.api;

import com.epam.cinema.controllers.models.FilmModel;
import com.epam.cinema.dtos.FilmDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Film management API")
@RequestMapping("/api/v1/films")
public interface FilmApi {

    @ApiOperation("Get film from Database")
    @GetMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    FilmModel getFilm(@PathVariable String title);

    @ApiOperation("Creating film")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    FilmModel createFilm(@Valid @RequestBody FilmDto filmDto);

    @ApiOperation("Update film")
    @PutMapping(value = "/{title}")
    @ResponseStatus(HttpStatus.OK)
    FilmModel updateFilm(@Valid @RequestBody FilmDto filmDto,
                         @PathVariable String title);

    @ApiOperation("Delete film from Database")
    @DeleteMapping(value = "/{title}")
    ResponseEntity<Void> deleteFilm(@PathVariable String title);

    @ApiOperation("Getting all films from Database")
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    List<FilmModel> getAllFilms();
}
