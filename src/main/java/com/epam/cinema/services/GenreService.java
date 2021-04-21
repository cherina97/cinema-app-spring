package com.epam.cinema.services;

import com.epam.cinema.dtos.GenreDto;

import java.util.List;

public interface GenreService {

    GenreDto getGenre(String genreName);

    GenreDto createGenre(GenreDto genreDto);

    GenreDto updateGenre(GenreDto genreDto, String genreName);

    void deleteGenre(String genreName);

    List<GenreDto> getAllGenres();
}
