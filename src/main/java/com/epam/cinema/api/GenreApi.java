package com.epam.cinema.api;

import com.epam.cinema.controllers.models.GenreModel;
import com.epam.cinema.dtos.GenreDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Genre management API")
@RequestMapping("/api/v1/genres")
public interface GenreApi {

    @ApiOperation("Get genre from Database")
    @GetMapping(value = "/{genreName}")
    @ResponseStatus(HttpStatus.OK)
    GenreModel getGenre(@PathVariable String genreName);

    @ApiOperation("Creating genre")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    GenreModel createGenre(@Valid @RequestBody GenreDto genre);

    @ApiOperation("Update genre")
    @PutMapping(value = "/{genreName}")
    @ResponseStatus(HttpStatus.OK)
    GenreModel updateGenre(@Valid @RequestBody GenreDto genre,
                           @PathVariable String genreName);

    @ApiOperation("Delete genre from Database")
    @DeleteMapping(value = "/{genreName}")
    ResponseEntity<Void> deleteGenre(@PathVariable String genreName);

    @ApiOperation("Getting all genres from Database")
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    List<GenreModel> getAllGenres();
}
