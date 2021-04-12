package com.epam.cinema.services.impl;

import com.epam.cinema.dtos.FilmDto;
import com.epam.cinema.mappers.MapperFilm;
import com.epam.cinema.models.Film;
import com.epam.cinema.repos.FilmRepository;
import com.epam.cinema.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService, MapperFilm{

    private final FilmRepository filmRepository;

    @Override
    public FilmDto getFilm(String filmTitle) {
        Film film = filmRepository.getFilm(filmTitle);
        return MapperFilm.INSTANCE.fromFilmToFilmDto(film);
    }

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        Film film = MapperFilm.INSTANCE.fromFilmDtoToFilm(filmDto);
        film = filmRepository.createFilm(film);
        return MapperFilm.INSTANCE.fromFilmToFilmDto(film);
    }

    @Override
    public FilmDto updateFilm(FilmDto filmDto, String filmTitle) {
        Film film = MapperFilm.INSTANCE.fromFilmDtoToFilm(filmDto);
        film = filmRepository.updateFilm(film, filmTitle);
        return MapperFilm.INSTANCE.fromFilmToFilmDto(film);
    }

    @Override
    public void deleteFilm(String filmTitle) {
        filmRepository.deleteFilm(filmTitle);
    }

    @Override
    public FilmDto fromFilmToFilmDto(Film film) {
        if (film == null) return null;

        return new FilmDto.Builder()
                .withId(film.getId())
                .withFilmTitle(film.getFilmTitle())
                .withDescription(film.getDescription())
                .withDuration(film.getDuration())
                .build();
    }

    @Override
    public Film fromFilmDtoToFilm(FilmDto filmDto) {
        if (filmDto == null) return null;

        return new Film.Builder()
                .withId(filmDto.getId())
                .withFilmTitle(filmDto.getFilmTitle())
                .withDescription(filmDto.getDescription())
                .withDuration(filmDto.getDuration())
                .build();
    }
}
