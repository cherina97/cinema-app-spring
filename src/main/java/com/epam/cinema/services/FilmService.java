package com.epam.cinema.services;

import com.epam.cinema.dtos.FilmDto;

public interface FilmService {

    FilmDto getFilm(String filmTitle);

    FilmDto createFilm(FilmDto filmDto);

    FilmDto updateFilm(FilmDto filmDto, String filmTitle);

    void deleteFilm(String filmTitle);
}
