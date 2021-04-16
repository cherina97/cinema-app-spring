package com.epam.cinema.services.impl;

import com.epam.cinema.dtos.FilmDto;
import com.epam.cinema.exceptions.FilmNotFoundException;
import com.epam.cinema.mappers.MapperFilm;
import com.epam.cinema.models.Film;
import com.epam.cinema.repos.FilmRepository;
import com.epam.cinema.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService, MapperFilm{

    private final FilmRepository filmRepository;

    @Override
    public FilmDto getFilm(String filmTitle) {
        Film film = filmRepository.findByFilmTitle(filmTitle)
                .orElseThrow(FilmNotFoundException::new);
        return MapperFilm.INSTANCE.fromFilmToFilmDto(film);
    }

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        Film film = MapperFilm.INSTANCE.fromFilmDtoToFilm(filmDto);
        film = filmRepository.save(film);
        return MapperFilm.INSTANCE.fromFilmToFilmDto(film);
    }

    @Override
    public FilmDto updateFilm(FilmDto filmDto, String filmTitle) {
        Film film = MapperFilm.INSTANCE.fromFilmDtoToFilm(filmDto);
        if (filmRepository.findByFilmTitle(filmTitle).isPresent()) {
            filmRepository.save(film);
        } else {
            throw new FilmNotFoundException();
        }
        return MapperFilm.INSTANCE.fromFilmToFilmDto(film);
    }

    @Override
    public void deleteFilm(String filmTitle) {
        Film film = filmRepository.findByFilmTitle(filmTitle)
                .orElseThrow(FilmNotFoundException::new);
        filmRepository.delete(film);
    }

    @Override
    public List<FilmDto> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(MapperFilm.INSTANCE::fromFilmToFilmDto)
                .collect(Collectors.toList());
    }

    @Override
    public FilmDto fromFilmToFilmDto(Film film) {
        if (film == null) return null;

        return new FilmDto.Builder()
                .withId(film.getId())
                .withFilmTitle(film.getFilmTitle())
                .withDescription(film.getDescription())
                .withDuration(film.getDuration())
                .withGenres(film.getGenres())
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
                .withGenres(filmDto.getGenres())
                .build();
    }
}
