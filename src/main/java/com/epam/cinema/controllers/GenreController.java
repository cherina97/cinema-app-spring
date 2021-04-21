package com.epam.cinema.controllers;

import com.epam.cinema.api.GenreApi;
import com.epam.cinema.controllers.assemblers.GenreAssembler;
import com.epam.cinema.controllers.models.GenreModel;
import com.epam.cinema.dtos.GenreDto;
import com.epam.cinema.services.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GenreController implements GenreApi {

    private final GenreService genreService;
    private final GenreAssembler genreAssembler;

    @Override
    public GenreModel getGenre(String genreName) {
        GenreDto genre = genreService.getGenre(genreName);
        return genreAssembler.toModel(genre);
    }

    @Override
    public GenreModel createGenre(GenreDto genre) {
        log.info("Create genre: {}", genre);
        GenreDto genreDto = genreService.createGenre(genre);
        return genreAssembler.toModel(genreDto);
    }

    @Override
    public GenreModel updateGenre(GenreDto genre,
                                  String genreName) {
        log.info("Update genre: {} to genre {}", genreName, genre);
        GenreDto genreDto = genreService.updateGenre(genre, genreName);
        return genreAssembler.toModel(genreDto);
    }

    @Override
    public ResponseEntity<Void> deleteGenre(String genreName) {
        log.info("Delete genre by title: {}", genreName);
        genreService.deleteGenre(genreName);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<GenreModel> getAllGenres(){
        log.info("Getting all genres from DB");
        return genreService.getAllGenres()
                .stream()
                .map(genreAssembler::toModel)
                .collect(Collectors.toList());
    }
}
