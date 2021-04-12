package com.epam.cinema.repos.impl;

import com.epam.cinema.models.Film;
import com.epam.cinema.repos.FilmRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class FilmRepositoryImpl implements FilmRepository {

    private final List<Film> films = new ArrayList<>();

    @Override
    public Film getFilm(String filmTitle){
        return films.stream()
                .filter(film -> film.getFilmTitle().equals(filmTitle))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Film createFilm(Film film){
        films.add(film);
        return film;
    }

    @Override
    public Film updateFilm(Film film, String filmTitle){
        boolean filmRemoved = films
                .removeIf(film1 -> film1.getFilmTitle().equals(filmTitle));

        if (filmRemoved){
            films.add(film);
        } else {
            throw new NoSuchElementException("No such film");
        }
        return film;
    }

    @Override
    public void deleteFilm(String filmTitle){
        films.removeIf(film -> film.getFilmTitle().equals(filmTitle));
    }

}
