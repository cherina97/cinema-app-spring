package com.epam.cinema.repos;

import com.epam.cinema.models.Film;

public interface FilmRepository {

    Film getFilm(String filmTitle);

    Film createFilm(Film film);

    Film updateFilm(Film film, String filmTitle);

    void deleteFilm(String filmTitle);
}
